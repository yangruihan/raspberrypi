#!/usr/bin/env python
#-*- coding:utf-8 -*-

import pygame
from pygame.locals import *

class Brush(object):
	def __init__(self):
		pass
		
class Painter(object):
	def __init__(self):
		self.screen = pygame.display.set_mode((800, 600))
		pygame.display.set_caption("Painter")
		self.clock = pygame.time.Clock()

	def run(self):
		self.screen.fill((255, 255, 255))
		while True:
			self.clock.tick(30)
			for event in pygame.event.get():
				if event.type == QUIT:
					return 
				elif event.type == KEYDOWN:
					pass
				elif event.type == MOUSEBUTTONDOWN:
					pass
				elif event.type == MOUSEMOTION:
					pass
				elif event.type == MOUSEBUTTONUP:
					pass

			pygame.display.update()

if __name__ == '__main__':
	app = Painter()
	app.run()
