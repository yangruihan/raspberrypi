#!/usr/bin/env python3
# -*- coding:utf-8 -*-

import time


FRAME_RATE = 0.016666667

if __name__ == '__main__':
    for i in range(100):
        for j in range(30):
            print()
        for j in range(10):
            print("--------------")
        time.sleep(FRAME_RATE)
