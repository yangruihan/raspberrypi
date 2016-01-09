#-*- coding:utf-8 -*-
__author__ = 'yrh'

import requests
from multiprocessing import Pool as ThreadPool
from lxml import etree
import re
import random

import sys
reload(sys)
sys.setdefaultencoding('utf-8')

def get_url(start, end):
    return ['http://www.pcwcn.com/____/' + str(i) for i in range(start, end + 1)]

def spider(url):
    result = []

    html = requests.get(url).text
    selector = etree.HTML(html)
    content = selector.xpath('/html/body/div[2]/div/div[2]/div[2]/ul')
    for each in content:
        try:
            # 跳过标题
            if each.xpath('li/text()')[0] == u'类型':
                continue

            if each.xpath('li[@class="t1"]/span/@class')[0] == 'ico_type_man':
                continue

            time = each.xpath('li/text()')[0]
            price = each.xpath('li/span/text()')[1]
            car_type = each.xpath('li/text()')[1]
            start = each.xpath('li/text()')[2]
            end = each.xpath('li/text()')[3]
            
            # 继续爬取详细信息
            next_url = each.xpath('li/a/@href')[0]
            html_next = requests.get(next_url).text
            selector_next = etree.HTML(html_next)
            state = selector_next.xpath('/html/body/div[@class="body"]/div[@class="body_bg"]/div[2]/div[@class="list"]/div/span[1]/span[2]/text()')[0]
            gasoline_costs = selector_next.xpath('//span[@class="money"]/text()')
            if len(gasoline_costs) > 0:
                gasoline_costs = gasoline_costs[0].split(' ')[0]
            else:
                gasoline_costs = 0
            totalDistance = selector_next.xpath('/html/body/div[@class="body"]/div[@class="body_bg"]/div[2]/div[@class="list"]/div[5]/div[1]/text()')
            max_pas_num = 0
            now_pas_num = 0
            print totalDistance
            if len(totalDistance) > 0:
                if len(totalDistance[0].split(" ")) == 1:
                    totalDistance = totalDistance[0][0 : len(totalDistance[0]) - 2]
                else:
                    max_pas_num = totalDistance[0][0 : len(totalDistance[0]) - 2].strip()
                    now_pas_num = selector_next.xpath('/html/body/div[@class="body"]/div[@class="body_bg"]/div[2]/div[@class="list"]/div[5]/div[2]/text()')[0][0 : len(totalDistance[0]) - 2].strip()
                    totalDistance = 0

            if max_pas_num == 0:
                max_pas_num = selector_next.xpath('/html/body/div[@class="body"]/div[@class="body_bg"]/div[2]/div[@class="list"]/div[6]/div[1]/text()')[0][0 : len(totalDistance[0]) - 2].strip()
                now_pas_num = selector_next.xpath('/html/body/div[@class="body"]/div[@class="body_bg"]/div[2]/div[@class="list"]/div[6]/div[2]/text()')[0][0 : len(totalDistance[0]) - 2].strip()

            add_info = selector_next.xpath('//div[@class="content"]/text()')[0]
            if len(add_info) == 0:
                add_info = ' '
            elif u'（pcwcn.com）' in add_info:
                add_info = add_info[0 : add_info.index('（pcwcn.com）')] + add_info[add_info.index('（pcwcn.com）') :]

            driver_id = random.randint(459, 10459)
            time = '2016-' + time[0 : len(time) - 3] + ' ' + str(random.randint(8, 23)) + ':' + str(random.randint(0, 59)) + ':' + str(random.randint(0, 59))

            if totalDistance == 0:
                s = 'INSERT INTO sharingcarinfo (driverID, totalDistance, start, end, time, state, carType, maxPasNum, nowPasNum, addedInfo) VALUES(' + str(driver_id) + ",0.0,'" + start + "','" + end + "','" + time + "',1,'" + car_type + "'," + str(max_pas_num) + ',' + str(now_pas_num) + ",'" + add_info + "');"
            else:
                s = 'INSERT INTO sharingcarinfo (driverID, totalDistance, start, end, time, state, carType, gasolineCosts, maxPasNum, nowPasNum, addedInfo) VALUES(' + str(driver_id) + "," + str(totalDistance) + ",'" + start + "','" + end + "','" + time + "',1,'" + car_type + "'," + gasoline_costs + ',' + str(max_pas_num) + ',' + str(now_pas_num) + ",'" + add_info + "');"
                    
            result.append(s)
        except Exception, e:
            print e
            continue

    return result

if __name__ == '__main__':

    urls = get_url(17, 152)

    for u in urls:
        print '开始爬取：' + u + '...'
        res = spider(u)
        # for r in res:
        #     print r
        with open('SharingCarInfo.txt', 'a') as f:
            for r in res:
                f.write(r + '\n')
        print u + '信息已爬取成功！'