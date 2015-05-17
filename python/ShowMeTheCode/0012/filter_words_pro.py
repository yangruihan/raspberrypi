#!/bin/env python
# -*- coding: utf-8 -*-

import re

#从文件读取信息，以列表形式返回
def read_file(filename):
    l = []
    with open(filename,'r') as fp:
        for line in fp.readlines():
            l.append(line.strip())
    return l

#生成对应的正则匹配规则
def gen_pattern(l):
    pattern = ''
    for string in l:
        pattern += string + '|'
    return pattern[:-1]

def input_replace(pattern):
    sentence = raw_input('Please enter a sentence:')
    print re.sub(pattern,'**',sentence)

def main():
    filename = 'filtered_words.txt'
    l = read_file(filename)
    pattern = gen_pattern(l)
    input_replace(pattern)

if __name__ == '__main__':
    main()
