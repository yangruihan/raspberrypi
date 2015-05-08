#!/usr/bin/env python3
# -*- coding:utf-8 -*-

import re
import glob

# 返回英文单词列表
def list_words(string):
	words = re.findall(r'[a-zA-Z]+\b', string)
	return words

# 计算出出现次数最多的单词
def most_number_word(word_list):
	str_dict = {}
	for item in word_list:
		if item in str_dict:
			str_dict[item] += 1
		else:
			str_dict[item] = 1
	str_dict = {str_dict[key]:key for key in str_dict}
	return(max(str_dict), str_dict[max(str_dict)])

# 获得当前目录中的所有txt文件列表
def get_file_list():
	return glob.glob('*.txt')	

if __name__ == '__main__':
	file_list = get_file_list()
	for file_name in file_list:
		with open(file_name, 'rd') as f:
			string = f.read()
			words = list_words(string)
			times, word = most_number_word(words)
			print("--'" + file_name +"'文件中出现最多的单词为'" + str(word) + "', 出现了 " + str(times) + ' 次')
