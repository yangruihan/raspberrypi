#!/usr/bin/env python3
# -*- coding:utf-8 -*-
# 任何一个英文的纯文本文件，统计其中的单词出现的个数

import os
import string

def stat_letter(filename):
	with open(filename, 'rb') as inputfile:
		str = inputfile.readlines()
		res = {}
		for s in str:
			s = s.strip()
			for s1 in s:
				if s1 in res:
					res[s1] += 1
				else:
					res[s1] = 1

	with open('result.txt', 'wb') as outputfile:
		for key in res:
			s = "%s : %s\n" % (key, res[key])
			outputfile.write(s)
		print("finished!")

if __name__ == '__main__':
	filename = raw_input('Input a file name: ')
	while not os.path.exists(filename):
		filename = raw_input('Input a RIGHT file name: ')

	stat_letter(filename)
