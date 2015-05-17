#!/usr/bin/env python
# -*- coding:utf-8 -*-

import pygame
from pygame.locals import *
from sys import exit

pygame.init()
SCREEN_SIZE = (640, 480)
screen = pygame.display.set_mode(SCREEN_SIZE, 0 ,32)

font = pygame.font.SysFont("arial", 14);
font_height = font.get_linesize()
event_text = []

while True:

	event = pygame.event.wait()
	event_text.append(str(event))
	#该切片保证了event_text里只保留一个屏幕的文字
	event_text = event_text[-SCREEN_SIZE[1] / font_height:]

	if event.type == QUIT:
		exit()

	screen.fill((0, 0, 0))

	y = SCREEN_SIZE[1] - font_height

	for text in reversed(event_text):
		screen.blit(font.render(text, True, (0, 255, 0)), (0, y))
		y -= font_height

	pygame.display.update()
