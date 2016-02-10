#!/usr/bin/env python3
# -*- coding:utf-8 -*-


class Screen(object):
    def __init__(self):
        self.__width = 0
        self.__height = 0

    @property
    def width(self):
        return self.__width

    @width.setter
    def width(self, width):
        self.__width = width

    @property
    def height(self):
        return self.__height

    @height.setter
    def height(self, height):
        self.__height = height

    @property
    def resolution(self):
        return self.__width * self.__height

if __name__ == '__main__':
    screen = Screen()
    screen.width = 1024
    screen.height = 728
    print('%s * %s = %s' % (screen.width, screen.height, screen.resolution))
