#!/usr/bin/env python3

from bs4 import BeautifulSoup
import requests
import json

url = 'http://pan.baidu.com/share/link?shareid=1613519143&uk=2453116636'

soup = BeautifulSoup(requests.get(url).text, "lxml")
url2 = 'http://pan.baidu.com' + \
       soup.find(class_='followcnt').contents[0].get('href')

# print(url2)

# print(requests.get(url2).text)
# s = requests.get('http://pan.baidu.com/pcloud/user/getinfo?bdstoken=null&query_uk=2821398601&channel=chunlei&clienttype=0&web=1').text
# print(s)
# s = requests.get(
#     'http://pan.baidu.com/pcloud/friend/getfollowlist?query_uk=2821398601&limit=25&start=0&bdstoken=null&channel=chunlei&clienttype=0&web=1').text

print(s)
# js = json.loads(s)
# print(len(js['follow_list']))
