#!/usr/bin/env python3
# -*- coding:utf-8 -*-

import os

def main():
    path = os.getcwd()
    for file in os.listdir(path):
        if os.path.isfile(os.path.join(path, file)):
            newname = file.replace('old_name', 'new_name')
            os.rename(os.path.join(path, file), os.path.join(path, newname))
            print('修改成功！\t' + file + '->' + newname)

if __name__ == '__main__':
    main()
