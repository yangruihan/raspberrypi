#!/usr/bin/env python3
#-*- coding:utf-8 -*-

import re

def count(filename):
	with open(filename, 'rb') as f:
		s = f.read()
		words = re.findall(r'[a-zA-Z0-9]+', s)
		return len(words)

if __name__ == '__main__':
	num = count('test.txt')
	print num

