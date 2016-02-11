#!/usr/bin/env python3
# -*- coding:utf-8 -*-


class Point(object):
    def __init__(self, x, y):
        self.__x = x
        self.__y = y

    @property
    def x(self):
        return self.__x

    @x.setter
    def x(self, xx):
        if isinstance(xx, int):
            self.__x = xx

    @property
    def y(self):
        return self.__y

    @y.setter
    def y(self, yy):
        if isinstance(yy, int):
            self.__y = yy

    def __str__(self):
        return '(%s, %s)' % (self.__x, self.__y)

