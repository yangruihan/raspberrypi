#!/usr/bin/env python
#-*- coding:utf-8 -*-

import pygame
from pygame.locals import *
from sys import exit

pygame.init()
try:
	screen = pygame.display.set_mode((640, 480), 0, 32)
except pygame.error, e:
	print "Sorry, can't create the display :-("
	print e
	exit()

font = pygame.font.SysFont('宋体', 40)
#font = pygame.font.Font("simsun.ttc", 40)
text_surface = font.render(u'hello world', True, (255, 0, 0))

x = 0
y = (480 - text_surface.get_height()) / 2

while True:
	for event in pygame.event.get():
		if event.type == QUIT:
			exit()
	screen.fill((0, 0, 0))

	x -= 0.5
	if x < -text_surface.get_width():
		x = 640 - text_surface.get_width()

	screen.blit(text_surface, (x, y))

	pygame.display.update()
