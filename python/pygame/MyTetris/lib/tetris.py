#!/usr/bin/env python
# -*- coding:utf-8 -*-

__author__ = 'Yrh'

import pygame
from pygame.locals import *
import util
from sound import play_sound
from shape import Tile, Shape

class Tetris(object):
    W = 12
    H = 20
    TILEW = 20              # the pixel width/height of a tile
    START = (100, 40)       # the playboard lefttop on background
    SPACE = 1000            # shape will fall after xxx ms (leve 1)
    def __init__(self, screen):
        self.stat = 'game'
        self.WIDTH = self.TILEW * self.W
        self.HEIGHT = self.TILEW * self.H
        self.screen = screen
        self.pause = False
        # the array save current situation
        # same as screen cood
        self.board = []
        for i in xrange(self.H):
            line = [ None ] * self.W
            self.board.append(line)
        # will display
        self.level = 1
        self.killed = 0
        self.score = 0
        # after this time, shape falls
        self.time = self.SPACE * 0.8 ** (self.level - 1)
        # save the elapsed time after last fail
        self.elapsed = 0
        # used for judge pressed firstly or for a long time
        self.pressing = 0
        # the moving shape
        self.shape = Shape(self.START, (self.WIDTH, self.HEIGHT), (self.W, self.H))
        self.shape.set_board(self.board)
        self.board_image = pygame.Surface((self.WIDTH, self.HEIGHT))
        # draw the background once
        self.screen.blit(pygame.image.load(util.file_path('background.jpg')).convert(), (0, 0))
        self.display_info()

    def update(self, elapse):
        for e in pygame.event.get():
            if e.type == KEYDOWN:
                self.pressing = 1
                self.move(e.key == K_UP, e.key == K_DOWN,
                          e.key == K_LEFT, e.key == K_RIGHT)
                if e.key == K_ESCAPE:
                    self.stat = 'menu'
                elif e.key == K_SPACE:
                    self.pause = not self.pause
            elif e.type == KEYUP and self.pressing:
                self.pressing = 0
            elif e.type == QUIT:
                self.stat = 'quit'

        if self.pause:
             self.draw()
             return self.stat
        if self.pressing:
            pressed = pygame.key.get_pressed()
            self.move(pressed[K_UP], pressed[K_DOWN],
                      pressed[K_LEFT], pressed[K_RIGHT])
        self.elapsed += elapse
        if self.elapsed >= self.time:
            self.next()
            self.elapsed = self.elapsed - self.time
            self.draw()
        return self.stat

    def move(self, u, d, l, r):
        if not (u or d or l or r):
            return
        # pressed for the first time
        # pressed for a long time
        if self.pressing == 1 or self.pressing > 10:
            if u:   self.shape.rotate()
            elif d: self.next()     # self.shape.move(0, 1) is bad
            elif l: self.shape.move(-1, 0)
            elif r: self.shape.move(1, 0)
            self.draw()
        self.pressing += 1

    def check_line(self):
        self.add_to_board()
        filled = []
        for i in xrange(self.H - 1, -1, -1):
            line = self.board[i]
            sum = 0
            for t in line:
                sum += 1 if t else 0
            if sum == self.W:
                filled.append(i)
            elif sum == 0
                break;
        if i == 0 and sum != 0:
            self.game_over()
        self.create_board_image() # used for killing animation
        self.kill_line(filled)
        self.create_board_image() # used for update

    def kill_line(self, filled=[]):
        if len(filled) == 0:
            return
        # play sound effect
        play_sound(str(len(filled)))
        # play animation
        mask = pygame.Surface((self.WIDTH, self.TILEW), SRCALPHA, 32)
        for i in xrange(5):
            if i % 2 == 0:
                mask.fill((255, 255, 255, 100))
            else:
                mask.fill((255, 255, 255, 200))
            self.screen.blit(self.board_image, self.START)
            for line in filled:
                self.screen.blit(mask, (
                        self.START[0],
                        self.START[1] + line * self.TILEW))
                pygame.display.update()
            pygame.time.wait(80)
        # remove filled lines
        [self.board.pop(l) for l in sorted(filled, reverse=True)]
        # fill with blank lines
        [self.board.insert(0, [None] * self.W) for l in filled]
        self.get_score(len(filled))

    def get_score(self, num):
        self.killed += num
        self.score += num * num * 10 * self.level
        self.level = 1 + self.killed // 10
        self.time = self.SPACE * 0.8 ** (self.level - 1)

    def add_to_board(self):
        for x in xrange(self.shape.SHAPEW):
            for y in xrange(self.shape.SHAPEH):
                if self.shape.shape[y][x]:
                    self.board[self.shape.y+y][self.shape.x+x] = Tile(
                            self.shape.color)