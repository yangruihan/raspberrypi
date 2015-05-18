#!/usr/bin/env python
#-*- coding:utf-8 -*-

import pygame
from pygame.locals import *
from sys import exit

pygame.init()
screen = pygame.display.set_mode((640, 480), 0, 32)

clock = pygame.time.Clock()

x = 0.
y = 0.
x_speed = 100.
y_speed = 100.

while True:

	for event in pygame.event.get():
		if event.type == QUIT:
			exit()

	pygame.draw.rect(screen, (255, 0, 0), (x, y, 5, 5))

	time_passed = clock.tick()
	time_passed_seconds = time_passed / 1000.0
	x_distance_moved = time_passed_seconds * x_speed
	y_distance_moved = time_passed_seconds * y_speed

	x += x_distance_moved
	y += y_distance_moved

	if x > 640. or x < 0.:
		#x -= 640.
		x_speed = -x_speed
	if y > 480. or y < 0.:
		#y -= 480.
		y_speed = -y_speed

	pygame.display.update()
