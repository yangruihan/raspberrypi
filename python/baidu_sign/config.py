#!/usr/bin/env python3
# encoding: utf-8


# 百度账号
userName = "用户名"             #不支持中文id，弄不明白编码，求大神修改一下
userPass = "密码"

# 接收邮箱
mailAddr = "你的qq@qq.com"      #其它游戏也可

# 发送邮箱
mailHost = "smtp.qq.com"        #可以设置其它邮箱
mailUser = "用户名"
mailPass = "密码"
mailPostfix = "qq.com"

# 是否发送邮件
sendMail = True

# 请求头
headers = dict()
headers["Connection"] = "keep-alive"
headers["Cache-Control"] = "max-age=0"
headers["Accept"] = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"
headers["User-Agent"] = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.107 Safari/537.36"
headers["Content-Type"] = "application/x-www-form-urlencoded"
headers["Accept-Encoding"] = "gzip,deflate,sdch"
headers["Accept-Language"] = "zh-CN,zh;q=0.8"
headers["Cookie"] = ""

# 百度使用的cookies
#cookies = ['BAIDUID=',
#    'UBI=',
#    'PASSID=',
#    'BAIDU_WISE_UID=',
#    'WAP20_1443063328=',
#    'BDUSS=',
#    'SSUDB=',
#    'PTOKEN=',
#    'PTOKEN=',
#    'STOKEN=',
#    'SAVEUSERID=',
#    'LASTLOGINTYPE=']
cookies = list()
