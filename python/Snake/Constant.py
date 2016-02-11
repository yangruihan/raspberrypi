#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from enum import Enum, unique


@unique
class RectType(Enum):
    Food = 0
    SnakeBody = 1


@unique
class MoveDirection(Enum):
    Left = 0
    Right = 1
    Up = 2
    Down = 3
