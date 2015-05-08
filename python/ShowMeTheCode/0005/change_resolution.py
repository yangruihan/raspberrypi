#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from PIL import Image
import glob

def change_resolution(pic_name, outputfilename, resolution):
	img = Image.open(pic_name)
	x, y = img.size

	changex = float(x) / resolution[0]
	changey = float(y) / resolution[1]
	
	# 判断分辨率是否满足
	if changex > 1 or changey > 1:
		change = changex if changex > changey else changey
		img.resize((int(x / change), int(y / change))).save(outputfilename)

# 得到该目录下的所有图片文件列表
def get_list():
	return glob.glob('*.jpg')

if __name__ == '__main__':
	imagelist = get_list()
	i = 0
	for pic_name in imagelist:
		print(pic_name)
		change_resolution(pic_name, 'result-'+pic_name, (1136, 640))
		i += 1
		print("第%s张图片已转换完成！" % str(i))
