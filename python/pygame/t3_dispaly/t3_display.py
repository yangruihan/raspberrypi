#!/usr/bin/env python
#-*- coding:utf-8 -*-

import pygame
from pygame.locals import *
from sys import exit

pygame.init()

screen = pygame.display.set_mode((640, 480), 0, 32)

Fullsreen = False

while True:

	for event in pygame.event.get():
		if event.type == QUIT:
			exit()
		if event.type == KEYDOWN:
			if event.key == K_f:
				Fullsreen = not Fullsreen
				if Fullsreen:
					screen = pygame.display.set_mode((640, 480), FULLSCREEN, 32)
				else:
					screen = pygame.display.set_mode((640, 480), 0, 32)

	screen.fill((0, 0, 255))
	pygame.display.update()


