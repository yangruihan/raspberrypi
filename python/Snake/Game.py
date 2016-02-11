#!/usr/bin/env python3
# -*- coding:utf-8 -*-


import time
from Chessboard import Chessboard
from Snake import Snake
from Food import Food

FRAME_RATE = 0.1

if __name__ == '__main__':
    c = Chessboard(20, 10)
    f = Food()
    s = Snake(c, f)
    while True:
        for j in range(30):
            print()
        s.draw()
        c.draw()
        s.move()
        time.sleep(FRAME_RATE)
