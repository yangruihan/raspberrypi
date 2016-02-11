#!/usr/bin/env python3
# -*- coding:utf-8 -*-


from Constant import MoveDirection
from Constant import RectType
from Point import Point


class Snake(object):
    """
    蛇类
    """
    def __init__(self, chessboard, food):
        self.__direction = MoveDirection.Right  #默认向右
        self.__body_point_list = [Point(0, 0)]  #记录蛇身体点的列表
        self.__chessboard = chessboard  #棋盘类
        self.__food = food  #食物类
        self.__food.generate(self.__chessboard.width, self.__chessboard.height, self.__body_point_list)  #生成食物

    @property
    def direction(self):
        return self.__direction

    @direction.setter
    def direction(self, direction):
        if isinstance(direction, MoveDirection):
            self.__direction = direction

    def _move(self):
        """
        移动
        """
        n = len(self.__body_point_list) - 1
        while n > 0:
            direction = self._get_move_direction(self.__body_point_list[n].x,
                                                 self.__body_point_list[n].y,
                                                 self.__body_point_list[n-1].x,
                                                 self.__body_point_list[n-1].y)
            self.__body_point_list[n] = self._get_moved_point(self.__body_point_list[n].x,
                                                              self.__body_point_list[n].y,
                                                              direction)
            n -= 1

        self.__body_point_list[0] = self._get_moved_point(self.__body_point_list[0].x,
                                                          self.__body_point_list[0].y,
                                                          self.__direction)

    def _get_forward_point(self):
        """
        获得蛇头前面的点
        :return: Point(x, y) 蛇头前面的点
        """
        return self._get_moved_point(self.__food.x, self.__food.y, self.__direction)

    def _eat_food(self):
        """
        检测是否吃到食物
        """
        if self.__body_point_list[0].x == self.__food.x and self.__body_point_list[0].y == self.__food.y:
            self.__body_point_list.insert(0, self._get_forward_point())  # 添加身体
            self.__food.generate(self.__chessboard.width, self.__chessboard.height, self.__body_point_list)  # 重新生成食物

    def _set_next_direction(self):
        """
        设置下一次移动的方向
        :return: direction 方向
        """


    # def _get_next_direction_1(self):
    #     """
    #     获得下一次移动方向策略1
    #     :return: 下一次移动方向
    #     """
    #     if self.__direction in (MoveDirection.Right, MoveDirection.Left):
    #         if self.__food.y < self.__body_point_list[0].y and self._can_move(MoveDirection.Up):
    #             return MoveDirection.Up
    #         elif self.__food.y > self.__body_point_list[0].y and self._can_move(MoveDirection.Down):
    #             return MoveDirection.Down
    #     else:
    #         if self.__food.x < self.__body_point_list[0].x and self._can_move(MoveDirection.Left):
    #             return MoveDirection.Left
    #         elif self.__food.x > self.__body_point_list[0].x and self._can_move(MoveDirection.Right):
    #             return MoveDirection.Right
    #
    # def _get_next_direction_2(self):
    #     """
    #     获得下一次移动方向策略2
    #     :return: 下一次移动方向
    #     """
    #     if self.__direction == MoveDirection.Right:
    #         if self.__food.x > self.__body_point_list[0].x and self._can_move(MoveDirection.Right):
    #             return MoveDirection.Right
    #         else:
    #             if self.__food. y < self.__body_point_list[0].y:
    #                 return MoveDirection.Up
    #             else:
    #                 return MoveDirection.Down



    def _can_move(self, direction):
        """
        判断是否能朝当前方向移动
        :return: True or False
        """
        return True

    def move(self):
        """
        移动并检查是否吃到食物,是否撞到蛇身
        """
        self._move()
        self._eat_food()
        self._set_next_direction()

    def _get_moved_point(self, x, y, direction):
        """
        得到移动之后的点
        :param x: 将要移动的x坐标
        :param y: 将要移动的y坐标
        :param direction: 将要移动的方向
        :return: Point(new_x, new_y) 移动后的x坐标 y坐标
        """
        if direction == MoveDirection.Right:
            return Point((x + 1) % self.__chessboard.width, y)
        elif direction == MoveDirection.Down:
            return Point(x, (y + 1) % self.__chessboard.height)
        elif direction == MoveDirection.Left:
            x = self.__chessboard.width - 1 if x - 1 < 0 else x - 1
            return Point(x, y)
        elif direction == MoveDirection.Up:
            y = self.__chessboard.height - 1 if y - 1 < 0 else y - 1
            return Point(x, y)

    def _get_move_direction(self, x, y, pre_x, pre_y):
        """
        得到将要移动的方向
        :param x: 当前要移动的x坐标
        :param y: 当前要移动的y坐标
        :param pre_x: 当前身体前一节的x坐标
        :param pre_y: 当前身体前一节的y坐标
        :return: direction 移动方向
        """
        if pre_y == y:
            if pre_x == x + 1 or (pre_x == 0 and x == self.__chessboard.width - 1):
                return MoveDirection.Right
            elif pre_x == x - 1 or (pre_x == self.__chessboard.width - 1 and x == 0):
                return MoveDirection.Left
        elif pre_x == x:
            if pre_y == y + 1 or (pre_y == 0 and y == self.__chessboard.height - 1):
                return MoveDirection.Down
            elif pre_y == y - 1 or (pre_y == self.__chessboard.height - 1 and y == 0):
                return MoveDirection.Up

    def draw(self):
        """
        将蛇身体和食物绘制到棋盘上
        """
        self.__chessboard.clear()
        self.__chessboard.fill(self.__food.x, self.__food.y, RectType.Food)
        for point in self.__body_point_list:
            self.__chessboard.fill(point.x, point.y, RectType.SnakeBody)

    def print_body_point_info(self):
        """
        打印蛇身体位置信息
        """
        print('--当前蛇身所占的位置:')
        for point in self.__body_point_list:
            print(point)
