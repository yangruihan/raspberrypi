#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup
import requests
import json
from email.mime.text import MIMEText
import smtplib


class Crawler(object):
    ERROR_PAGE_TITLE = ['页面不存在 - 百度云', '百度云 网盘-链接不存在', '百度云升级']

    def __init__(self, max_deep=5):
        self.user_count = 0  # 一共获取的用户数
        self.item_count = 0  # 一共获取的资源数
        self.share_every_page_num = 60  # 每页显示的分享数目
        self.follow_every_page_num = 24  # 每页显示的订阅者数目
        self.max_deep = max_deep

    def get_info(self, uk, deep):
        if deep > self.max_deep:
            return

        # # 构建请求头数据
        # headers = {
        #     "Host": "hm.baidu.com",
        #     "User-Agent": "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:44.0) Gecko/20100101 Firefox/44.0",
        #     "Accept": "image/png,image/*;q=0.8,*/*;q=0.5",
        #     "Accept-Language": "zh-CN,en-US;q=0.7,en;q=0.3",
        #     "Accept-Encoding": "gzip, deflate",
        #     "Referer": "http://pan.baidu.com/share/home?uk=" + uk + "&view=follow",
        #     "Cookie": "BAIDUID=EC00FDBBA2C26B3D4F66ADFF1FE60A7C:FG=1; BIDUPSID=EC00FDBBA2C26B3D4F66ADFF1FE60A7C; PSTM=1456714824; PANWEB=1; Hm_lvt_7a3960b6f067eb0085b7f96ff5e660b0=1456748444; bdshare_firstime=1456748445696; PANPSC=17785268564342168302%3AV4xYP%2BguMp7fLM6jM73WzVN59bxoJEX1MMKOMtLkW73MtF6cdpAYPq6XwoDlj7S8fbZ%2FbYW506Yrh7mwRYuAFryHDAnhPhMzXW37a4TinLU%2F3LIl4sLPEoVYF2gE8DiGyMwwOTBV9B8hNwW%2F7DX2I7AdDI4jCRTlYfOQu1Ukkq9gRjm%2F7z4P5fvqPIbe4OQ9bU%2FOYWFuCwM%3D; Hm_lvt_adf736c22cd6bcc36a1d27e5af30949e=1456749856; H_PS_PSSID=1467_15053_12177_10634; Hm_lpvt_7a3960b6f067eb0085b7f96ff5e660b0=1456767011; Hm_lpvt_adf736c22cd6bcc36a1d27e5af30949e=1456767011; BDRCVFR[Ups602knC30]=mk3SLVN4HKm",
        #     "Connection": "keep-alive",
        # }

        headers = {
            "Accept": "image/webp,image/*,*/*;q=0.8",
            "Accept-Encoding": "gzip, deflate, sdch",
            "Accept-Language": "zh-CN,zh;q=0.8",
            "Cache-Control": "max-age=0",
            "Connection": "keep-alive",
            "Cookie": "BAIDUID=EC00FDBBA2C26B3D4F66ADFF1FE60A7C:FG=1; BIDUPSID=EC00FDBBA2C26B3D4F66ADFF1FE60A7C; PSTM=1456714824; PANWEB=1; Hm_lvt_7a3960b6f067eb0085b7f96ff5e660b0=1456748444; bdshare_firstime=1456748445696; PANPSC=12415901468523393894%3AV4xYP%2BguMp7HJKjeqZyXDFN59bxoJEX1MMKOMtLkW73MtF6cdpAYPq6XwoDlj7S8fbZ%2FbYW506Yrh7mwRYuAFryHDAnhPhMzXW37a4TinLU%2F3LIl4sLPEoVYF2gE8DiGyMwwOTBV9B8hNwW%2F7DX2I7AdDI4jCRTlYfOQu1Ukkq9gRjm%2F7z4P5fvqPIbe4OQ9bU%2FOYWFuCwM%3D; Hm_lvt_adf736c22cd6bcc36a1d27e5af30949e=1456749856; H_PS_PSSID=1467_15053_12177_10634; Hm_lpvt_7a3960b6f067eb0085b7f96ff5e660b0=1456768027; Hm_lpvt_adf736c22cd6bcc36a1d27e5af30949e=1456768027; BDRCVFR[Ups602knC30]=mk3SLVN4HKm; Hm_lvt_773fea2ac036979ebb5fcc768d8beb67=1456767284; Hm_lpvt_773fea2ac036979ebb5fcc768d8beb67=1456767284; Hm_lvt_b181fb73f90936ebd334d457c848c8b5=1456767284; Hm_lpvt_b181fb73f90936ebd334d457c848c8b5=1456767284; BDUSS=3g4TE9xdm5UZU9Ib3NBfmxOcVR3Qk83anBqQ2Z3LWdYd01iTDRxMmprNC1EdnhXQVFBQUFBJCQAAAAAAAAAAAEAAAC3XS0Tuse6x1~Ex7K7xq3E4wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD6B1FY-gdRWd",
            "Host": "pan.baidu.com",
            "Referer": "http://pan.baidu.com/share/home?uk=" + uk + "&view=share",
            "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36",
        }

        info_url = 'http://pan.baidu.com/pcloud/user/getinfo?bdstoken=null&query_uk=' + uk + '&channel=chunlei&clienttype=0&web=1'

        js = json.loads(requests.get(info_url, headers=headers).text)
        pubshare_count = js['user_info']['pubshare_count']  # 获得分享文件数
        follower_count = js['user_info']['follow_count']  # 获得订阅人数

        # 获得该用户的资源
        self._get_share_info(uk, pubshare_count, headers)

        # 遍历该用户的订阅者资源
        self._get_follower_info(uk, follower_count, headers, deep)

    def _get_follower_info(self, uk, follower_count, headers, deep):
        """
        :param follow_count: 订阅者数量
        :param headers: 请求头
        """
        if int(follower_count) == 0:
            return

        follower_urls = []
        for i in range(int(follower_count) // self.follow_every_page_num):
            follower_url = 'http://pan.baidu.com/pcloud/friend/getfollowlist?' + \
                           'query_uk=' + uk + \
                           '&limit=' + str(self.follow_every_page_num) + \
                           '&start=' + str(i * self.follow_every_page_num) + \
                           '&bdstoken=null&channel=chunlei&clienttype=0&web=1'
            follower_urls.append(follower_url)
        if int(follower_count) % self.follow_every_page_num != 0:
            follower_url = 'http://pan.baidu.com/pcloud/friend/getfollowlist?' + \
                           'query_uk=' + uk + \
                           '&limit=' + str(self.follow_every_page_num) + \
                           '&start=' + str(int(follower_count) // self.follow_every_page_num) + \
                           '&bdstoken=null&channel=chunlei&clienttype=0&web=1'
            follower_urls.append(follower_url)
        for url in follower_urls:
            try:
                js = json.loads(requests.get(url, headers=headers).text)
                follower_list = js['follow_list']
                for follower in follower_list:
                    uk = str(follower['follow_uk'])
                    self.get_info(uk, deep + 1)
            except Exception as e:
                print(e)
                return

    def _get_share_info(self, uk, pubshare_count, headers):
        """
        :param pubshare_count: 分享文件数量
        :param headers: 请求头
        """
        if int(pubshare_count) == 0:
            return

        self.user_count += 1  # 获得的用户数+1
        print("正在获得第" + str(self.user_count) + "用户的资源信息：")
        get_share_count = 0  # 记录获得的资源的数量

        share_urls = []
        for i in range(1, int(pubshare_count) // self.share_every_page_num + 1):
            share_url = 'http://pan.baidu.com/share/homerecord?uk=%s&page=%s&pagelength=%s' % (
                uk, i, self.share_every_page_num)
            share_urls.append(share_url)
        if int(pubshare_count) % self.share_every_page_num != 0:
            share_url = 'http://pan.baidu.com/share/homerecord?uk=%s&page=%s&pagelength=%s' \
                        % (uk, int(pubshare_count) // self.share_every_page_num + 1, self.share_every_page_num)
            share_urls.append(share_url)

        for url in share_urls:
            try:
                js = json.loads(requests.get(url, headers=headers).text)
                share_list = js['list']
                share_item_info = []
                for i in share_list:
                    share_item_url = 'http://pan.baidu.com/s/' + i['shorturl']
                    share_item_title = i['typicalPath'].split('/')[-1]
                    share_item_info.append(share_item_title + "|" + share_item_url)
                    get_share_count += 1
                    print("\t获取第" + str(get_share_count) + "个资源信息：" +
                          share_item_title + "|" + share_item_url)

                    # # 解决乱码问题
                    # r = requests.get(share_item_url, headers=headers)
                    # r.encoding = 'utf-8'
                    #
                    # soup = BeautifulSoup(r.text, "lxml")
                    # item_name = str(soup.title.string)
                    # if item_name not in Crawler.ERROR_PAGE_TITLE:
                    #     share_item_info.append(item_name.split("_免费高速下载|百度云 网盘-分享无限制")[0] + "||" + share_item_url)
                    #     get_share_count += 1
                    #     print("\t获取第" + str(get_share_count) + "个资源信息：" +
                    #           item_name.split("_免费高速下载|百度云 网盘-分享无限制")[0] + "||" + share_item_url)
                    # else:
                    #     get_share_count += 1
                    #     print("\t第" + str(get_share_count) + "资源信息无效，跳过")

                with open("item_names", "a") as f:
                    for name in share_item_info:
                        f.write(name + "\n")
                        self.item_count += 1  # 获取的资源数加一
                    share_item_info.clear()
            except Exception as e:
                print(e)
                return

        print("-----信息写入完成-----")


mail_to_list = list()
mail_host = 'smtp.qq.com'  # 设置服务器
mail_user = '770362426'  # 用户名
mail_pass = 'yrh0306'  # 密码
mail_postfix = 'qq.com'  # 发件箱后缀


def send_mail(to_list, sub, content):
    me = '<' + mail_user + "@" + mail_postfix + '>'
    msg = MIMEText(content, _subtype='plain', _charset='utf8')
    msg['Subject'] = sub
    msg['From'] = me
    msg['To'] = ";".join(to_list)
    try:
        server = smtplib.SMTP()
        server.connect(mail_host)
        server.login(mail_user, mail_pass)
        server.sendmail(me, to_list, msg.as_string())
        server.close()
        return True
    except Exception as e:
        print(e)
        return False


if __name__ == '__main__':
    crawler = Crawler(20)
    crawler.get_info(uk='2569666980', deep=0)

    mail_to_list.append("yangruihan@vip.qq.com")
    content = '-----资源爬取结果-----\n' + \
              '\t成功爬取' + str(crawler.item_count) + "个资源\n" + \
              "\t共访问" + str(crawler.user_count) + "个用户"
    if send_mail(mail_to_list, '百度云资源爬取', content):
        print(u'\n邮件发送成功')
    else:
        print(u'\n邮件发送失败')