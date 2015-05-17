#!/usr/bin/env python
# -*- coding:utf-8 -*-

background_image_filename = 'bg.jpg'

#导入pygame库
import pygame
#导入一些常用的函数和常量
from pygame.locals import *
#使用sys.exit来退出程序
from sys import exit

#初始化pygame，为使用硬件做准备
pygame.init()

screen = pygame.display.set_mode((1120, 630), RESIZABLE, 32)
pygame.display.set_caption('Hello World!')

background = pygame.image.load(background_image_filename).convert()

#游戏主循环
while True:

	for event in pygame.event.get():
		if event.type == QUIT:
			exit()

		screen.blit(background, (0, 0))

		x, y = pygame.mouse.get_pos()
		print (x, y)

		pygame.display.update()
