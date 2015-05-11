#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# 有一个目录，里面是你自己写的程序，统计一下你写过多少行代码。包括空行和注释，分别列出来

import os
import glob
import re

def get_file_list():
    return glob.glob('*')

def file_read(filename):
    n2 = n3 = 0
    with open(filename, 'r') as f:
        linelist = f.readlines()

    for string in linelist:
        if re.match(r'#', string) != None:
            n2 += 1
        elif re.match(r'^ *\n', string) != None:
            n3 += 1

    return len(linelist), n2, n3

if __name__ == '__main__':
    n1 = n2 = n3 = 0
    filepath = raw_input('请输入代码文件夹路径：')
    os.chdir(filepath)
    file_list = get_file_list()
    for filename in file_list:
        n1 += file_read(filename)[0]
        n2 += file_read(filename)[1]
        n3 += file_read(filename)[2]

    print('文件夹内内容总行数：' + str(n1) + '行')
    print('其中：')
    print('\t 代码总行数：' + str(n1 - n2 - n3))
    print('\t 注释总行数：' + str(n2))
    print('\t 空行总行数：' + str(n3))

