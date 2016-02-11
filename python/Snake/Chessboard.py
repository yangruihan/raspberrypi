#!/usr/bin/env python3
# -*- coding:utf-8 -*-


from Constant import RectType

__author__ = 'Yrh'


# 棋盘类
class Chessboard(object):
    """
    棋盘类
    """

    def __init__(self, width=80, height=20):
        """
        :param width 棋盘宽度
        :param height 棋盘高度
        """
        self.__width = 80 if width <= 0 else width
        self.__height = 20 if height <= 0 else height
        self.__content = [0 for _ in range(width * height)]

    @property
    def width(self):
        return self.__width

    @property
    def height(self):
        return self.__height

    def fill(self, x, y, rect_type):
        """
        根据给定x, y填充
        :param x 横坐标
        :param y 纵坐标
        :param rect_type: 填充类型 (RectType.Food 食物 RectType.SnakeBody 蛇身体)
        """
        if x < 0 or x >= self.__width or y < 0 or y >= self.__height:
            return

        if rect_type in (RectType.Food, RectType.SnakeBody):
            self.__content[y * self.__width + x] = rect_type

    def clear(self):
        """
        清空棋盘
        """
        self.__content = [0 for _ in range(self.__width * self.__height)]

    def clear_snake(self):
        """
        清空蛇
        """
        for i in range(len(self.__content)):
            if self.__content[i] == RectType.SnakeBody:
                self.__content[i] = 0

    def draw(self):
        """
        绘制棋盘
        """
        print('+' + ''.join([' ' for _ in range(self.__width)]) + '+')
        for i in range(self.__height):
            print(' ', end='')
            for j in range(self.__width):
                s = ' '
                if self.__content[i * self.__width + j] == RectType.Food:
                    s = '*'
                elif self.__content[i * self.__width + j] == RectType.SnakeBody:
                    s = '#'
                print(s, end='')
            print()
        print('+' + ''.join([' ' for _ in range(self.__width)]) + '+')


if __name__ == '__main__':
    c2 = Chessboard(80, 20)
    c2.fill(0, 0, RectType.SnakeBody)
    c2.fill(1, 0, RectType.SnakeBody)
    c2.fill(2, 0, RectType.SnakeBody)
    c2.fill(3, 0, RectType.SnakeBody)
    c2.fill(4, 0, RectType.SnakeBody)
    c2.fill(5, 0, RectType.SnakeBody)
    c2.draw()
