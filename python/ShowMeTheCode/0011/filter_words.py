#!/usr/bin/env python3
# -*- coding:utf-8 -*-

def read_file(filename):
	l = []
	with open(filename, 'r') as fp:
		for line in fp.readlines():
			l.append(line.strip())
	return l

def input_check(l):
	string = raw_input('Please enter word: ')
	if string in l:
		print 'Freedom'
	else:
		print 'Human Rights'

if __name__ == '__main__':
	filename = 'filtered_words.txt'
	l = read_file(filename)
	input_check(l)
