#!/usr/bin/env python
# -*- coding:utf-8 -*-

__author__ = 'Yrh'

import tetris

class Main(object):
    def __init__(self, screen):
        self.screen = screen

    def run(self, elapse):
        return self.tetris.update(elapse)

    def start(self, kind):
        if kind == 8:
            self.tetris = tetris.Tetris(self.screen)
        else:
            self.tetris = eval("tetris.Tetris" + str(kind) + "(self.screen)")