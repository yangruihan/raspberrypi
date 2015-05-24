#!/usr/bin/env python
# -*- coding:utf-8 -*-

__author__ = 'Yrh'

import pygame
from pygame.locals import *
from util import myprint
from sound import play_sound


class Menu(object):
    OPTS = [
        'LEVEL 1',
        'LEVEL 2',
        'LEVEL 3',
        'LEVEL 4',
        'LEVEL 5',
        'LEVEL 6',
        'LEVEL 7',
        'NORMAL',
        'QUIT'
    ]

    def __init__(self, screen):
        self.screen = screen
        self.current = 0

    def run(self, elapse):
        self.draw()
        for e in pygame.event.get():
            if e.type == QUIT:
                return 'quit'
            elif e.type == KEYDOWN:
                if e.key == K_UP:
                    self.current = (self.current - 1) % len(self.OPTS)
                    play_sound('menu')
                elif e.key == K_DOWN:
                    self.current = (self.current + 1) % len(self.OPTS)
                    play_sound('menu')
                elif e.key == K_RETURN:
                    return self.OPTS[self.current].lower()
        return 'menu'

    def draw(self):
        for idx in xrange(len(self.OPTS)):
            if idx == self.current:
                myprint(self.screen, self.OPTS[idx], (250, 50 * idx + 25))
            else:
                myprint(self.screen, self.OPTS[idx], (250, 50 * idx + 25),
                        color=(160, 160, 160))
