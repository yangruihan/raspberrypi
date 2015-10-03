#!/usr/bin/env python
# encoding: utf-8

'''
Created on 2014-2-20

@author: Vincent

@Modify on 2015-6-24 by LiangCha
'''

import sys
import getopt
import gzip
import json
import re
import time
import config
import smail
import urllib.parse
import http.cookiejar
from http.client import HTTPConnection
from htmlutils import TieBaParser
import httputils as utils

# 请求头
headers = config.headers

# cookie
cookies = config.cookies

# 用户名和密码
userName = config.userName
userPass = config.userPass

# 邮件设置
smail.mail_host = config.mailHost
smail.mail_user = config.mailUser
smail.mail_pass = config.mailPass
smail.mailto_list.append(config.mailAddr)
smail.mail_postfix = config.mailPostfix

# 是否发送邮件
sendMail = config.sendMail 

# 是否志获取cookies
getCookies = False

# 反馈信息列表
mailMessages = list()

# 个人信息
userInfo = {}

def login(account, password):
    '''登录'''
    global cookies
    global mailMessages
    headers["Host"] = "wappass.baidu.com"
    if not cookies:
        print("无有效的cookies，开始登入！")
        mailMessages.append("无有效的cookies，开始登入！\n")
        body = "username={0}&password={1}&submit=%E7%99%BB%E5%BD%95&quick_user=0&isphone=0&\
            sp_login=waprate&uname_login=&loginmerge=1&vcodestr=&u=http%253A%252F%252Fwap.baidu\
            .com%253Fuid%253D1392873796936_247&skin=default_v2&tpl=&ssid=&from=&uid=13928737969\
            36_247&pu=&tn=&bdcm=3f7d51b436d12f2e83389b504fc2d56285356820&type=&bd_page_type="
        body = body.format(account, password)
        conn = HTTPConnection("wappass.baidu.com", 80)
        conn.request("POST", "/passport/login", body, headers)
        resp = conn.getresponse()
        cookies += utils.getCookiesFromHeaders(resp.getheaders())
        print("你的cookies:")
        print(cookies)
        utils.saveCookies(headers, cookies)
        # 登录成功会返回302
        return True if resp.code == 302 else False
    else:
        print("已有cookies。\n")
        mailMessages.append("已有cookies。\n")
        utils.saveCookies(headers, cookies)
        return True


def getTieBaList():
    '''获取已关注的贴吧列表'''
    conn = HTTPConnection("tieba.baidu.com", 80)
    conn.request("GET", "/mo/m?tn=bdFBW&tab=favorite", "", headers)
    resp = conn.getresponse()
    tieBaParser = TieBaParser()
    tieBaParser.feed(resp.read().decode())
    tbList = tieBaParser.getTieBaList()
    return tbList


def getSignInfo(tieBaName):
    '''获取贴吧签到信息'''
    queryStr = urllib.parse.urlencode({"kw":tieBaName, "ie":"utf-8", "t":0.571444})
    conn = HTTPConnection("tieba.baidu.com", 80)
    conn.request("GET", "/sign/loadmonth?" + queryStr, "", headers)
    data = gzip.decompress(conn.getresponse().read()).decode("GBK")
    signInfo = json.loads(data)
    return signInfo


tbsPattern = re.compile('"tbs" value=".{20,35}"')

def signIn(tieBaName):
    '''签到'''
    # 获取页面中的参数tbs
    conn1 = HTTPConnection("tieba.baidu.com", 80)
    queryStr1 = urllib.parse.urlencode({"kw": tieBaName})
    conn1.request("GET", "/mo/m?" + queryStr1, "", headers)
    html = conn1.getresponse().read().decode()
    try:
        tbs = tbsPattern.search(html).group(0)[13:-1]
    except Exception as e:
        #print("未知错误: " + str(e))
        return {"no":65535, "error":"未知错误:" + str(e)}
    # 签到
    conn2 = HTTPConnection("tieba.baidu.com", 80)
    body = urllib.parse.urlencode({"kw":tieBaName, "tbs":tbs, "ie":"utf-8"})
    conn2.request("POST", "/sign/add" , body , headers)
    resp2 = conn2.getresponse()
    data = json.loads((gzip.decompress(resp2.read())).decode())
    return data


def getUserInfo():
    '''获取个人信息'''
    headers.pop("Host")
    conn = HTTPConnection("tieba.baidu.com", 80)
    conn.request("GET", "/f/user/json_userinfo", "", headers)
    resp = conn.getresponse()
    data = gzip.decompress(resp.read()).decode("GBK")
    global userInfo
    userInfo = json.loads(data)
    #print(userInfo)

def sendLog(logList):
    '''向邮箱发送日志信息'''
    message = '\n-------------------------------------\n'.join(mailMessages)
    if sendMail:
        return smail.send_mail(smail.mailto_list, '贴吧每日签到', message)
    else:
        print(message)
        return


def usage():
    print("Usage: python3 baiduclient.py [OPTION]")
    print("\t-c\t\tJust get cookies.")
    print("\t-s\t\tSend log by email.")
    print("\t-h\t\tPrint this message.")

def parseArgs(argv):
    global sendMail
    global getCookies
    opts, args = getopt.getopt(argv[1:], "csh")
    for op ,value in opts:
        if op == '-c':
            getCookies = True
        elif op == '-s':
            sendMail = True
        elif op == '-h':
            usage()
            sys.exit(0)

    
if __name__ == "__main__":

    parseArgs(sys.argv)
    ok = login(userName, userPass)
    getUserInfo()
    if not userInfo:
        cookies = list()
        time.sleep(1)
        ok = login(userNmae, userPass)
        if ok:
            getUserInfo()
        else:
            mailMessages.append("登入失败！\n")
            sendLog(mailMessages)
            exit(1)

    print(userInfo["data"]["user_name_weak"] + "~~~登录成功\n------\n")
    mailMessages.append(userInfo["data"]["user_name_weak"] + "~~~登录成功!\n")
    if getCookies: exit(0)
    time.sleep(1)

    for tb in getTieBaList():
        info = signIn(tb)
        message = tb + '吧：\n'
        count = 3
        while info['no'] != 0 and info['no'] != 1101:
            count -= 1
            if count <= 0: break
            message += '签到失败，重试。原因：' + info['error'] + '\n'
            time.sleep(3)
            info = signIn(tb)

        if info['no'] == 0:
            message += '签到成功！' + '\n'
            message += "签到天数:" + str(info["data"]["uinfo"]["cout_total_sing_num"]) + '\n'
            message += "连续签到天数:" + str(info["data"]["uinfo"]["cont_sign_num"]) + '\n'
        else:
            message += '签到失败！' + '\n'
            message += info['error'] + '\n'
        #print(message)
        mailMessages.append(message)
        time.sleep(1)

    sendLog(mailMessages)

    exit(0)
