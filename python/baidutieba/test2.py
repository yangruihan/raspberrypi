# -*- coding: utf-8 -*-
import requests
import re
from multiprocessing import Pool as ThreadPool

# 修改自己的cookies
cookie = 'BAIDUID=63FF6259333751C221FBE11F226CAC28:FG=1; BDUSS=zBCZWc5aFhZOWFYeUNlajkxWklQMGUzN1FsQnNqalZJeXhFVn5CN2FmenAxRFJXQVFBQUFBJCQAAAAAAAAAAAEAAAC3XS0Tuse6x1~Ex7K7xq3E4wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOlHDVbpRw1WQ; SSUDB=zBCZWc5aFhZOWFYeUNlajkxWklQMGUzN1FsQnNqalZJeXhFVn5CN2FmenAxRFJXQVFBQUFBJCQAAAAAAAAAAAEAAAC3XS0Tuse6x1~Ex7K7xq3E4wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOlHDVbpRw1WQ; H_WISE_SIDS=100041_100040_100288'

# 构建请求头数据
headers = {
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
    'Accept-Encoding': 'gzip, deflate, sdch',
    'Accept-Language': 'zh-CN,zh;q=0.8,en;q=0.6',
    'Cache-Control': 'max-age=0',
    'Connection': 'keep-alive',
    'Cookie': cookie,
    'DNT': '1',
    'Host': 'tieba.baidu.com',
    'Upgrade-Insecure-Requests': '1',
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.99 Safari/537.36'
}

urls = []


# 获取关注贴吧列表
def find_kw():
    page_count = 1
    kw_list = []
    while 1:
        like_url = 'http://tieba.baidu.com/f/like/mylike?&pn=%d' % page_count
        like_html = requests.get(url=like_url, headers=headers).text
        re_kw = re.compile(ur'<a href="/f\?kw=(.+?)" title="(.+?)"')
        temp_kw = re_kw.findall(like_html)
        if not temp_kw:
            break
        if not kw_list:
            kw_list = temp_kw
        else:
            kw_list += temp_kw
        page_count += 1

    if kw_list:
        for kw in kw_list:
            urls.append('http://tieba.baidu.com/mo/m?kw=' + kw[0] + '\\' + kw[0] + '\\' + kw[1])

    print u'我喜欢的%d个贴吧:' % len(kw_list)


error_titles = []


# 签到
def sign(url):
    # sign_url = 'http://tieba.baidu.com/mo/m?kw=' + kw
    sign_url = url.split('\\')[0]
    kw = url.split('\\')[1]
    title = url.split('\\')[2]

    sign_html = requests.get(url=sign_url, headers=headers).text

    try:
        is_sign = re.findall(u'已签到', sign_html)

        if is_sign:
            print title + u' ok'

            return True
        else:
            re_fid = re.compile(r'<input type="hidden" name="fid" value="(.+?)"\/>')
            fid = re.findall(re_fid, sign_html)
            if len(fid) == 0:
                fid = re.findall(r'fid=(.*?)&', sign_html, re.S)[0]
            else:
                fid = fid[0]

            re_tbs = re.compile(r'<input type="hidden" name="tbs" value="(.+?)"\/>')
            tbs = re.findall(re_tbs, sign_html)
            if len(tbs) == 0:
                tbs = re.findall(r'tbs=(.*?)&', sign_html, re.S)[0]
            else:
                tbs = tbs[0]

            data = {
                'tbs': tbs,
                'fid': fid,
                'kw': kw
            }

            print title + u' sign'
            sign_url = 'http://tieba.baidu.com/mo/q---C367D41E4214449AC861EDF6CE73CD4E%3AFG%3D1--1-3-0--2--wapp_1443524105422_889/sign?tbs=' + tbs + '&fid=' + fid + '+&kw=' + kw

            requests.get(url=sign_url, headers=headers, data=data)

            return True

    except Exception, e:
        print title + u' error'

        error_titles.append(title)

        return False


if __name__ == '__main__':

    find_kw()
    # 设置进程数
    pool = ThreadPool(8)
    pool.map(sign, urls)
    pool.close()
    pool.join()

    print u'\n\n---------------签到完成---------------'
    if len(error_titles) > 0:
        print u'失败列表：'
    for i in error_titles:
        print '\t' + i


