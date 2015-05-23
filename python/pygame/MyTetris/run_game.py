#!/usr/bin/env python
# -*- coding:utf-8 -*-

__author__ = 'Yrh'

import sys, os

try:
    libdir = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'lib')
    sys.path.insert(0, libdir)
except:
    sys.path.insert(0, os.path.join(sys.path[0], 'lib'))
    pass

import game

game.run()
