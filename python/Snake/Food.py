#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from random import randint
from Point import Point

class Food(object):
    """
    食物类
    """
    def __init__(self):
        self.__x = 0
        self.__y = 0

    @property
    def x(self):
        return self.__x

    @property
    def y(self):
        return self.__y

    def generate(self, width, height, body_list):
        self.__x = randint(0, width - 1)
        self.__y = randint(0, height - 1)
        flag = 0
        while flag != len(body_list):
            flag = 0
            for point in body_list:
                if point.x == self.__x and point.y == self.__y:
                    self.__x = randint(0, width - 1)
                    self.__y = randint(0, height - 1)
                    break
                else:
                    flag += 1

