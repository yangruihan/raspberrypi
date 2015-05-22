#!/usr/bin/env python
#-*- coding:utf-8 -*-
SCREEN_SIZE = (640, 480)
 
# 重力因子，实际上是单位 像素/平方秒
GRAVITY = 250.0
# 弹力系数，不要超过1!
BOUNCINESS = 0.7
 
import pygame
from pygame.locals import *
from random import randint
from gameobjects.vector2 import Vector2
 
def stero_pan(x_coord, screen_width):
    """这个函数根据位置决定要播放声音左右声道的音量"""
    right_volume = float(x_coord) / screen_width
    left_volume = 1.0 - right_volume
    return (left_volume, right_volume)
 
class Ball():
    def __init__(self, position, speed, image, bounce_sound):
        self.position = Vector2(position)
        self.speed = Vector2(speed)
        self.image = image
        self.bounce_sound = bounce_sound
        self.age = 0.0
 
    def update(self, time_passed):
        w, h = self.image.get_size()
        screen_width, screen_height = SCREEN_SIZE
 
        x, y = self.position
        x -= w/2
        y -= h/2
        # 是不是要反弹了
        bounce = False
 
        # 小球碰壁了么？
        if y + h >= screen_height:
            self.speed.y = -self.speed.y * BOUNCINESS
            self.position.y = screen_height - h / 2.0 - 1.0
            bounce = True
        if x <= 0:
            self.speed.x = -self.speed.x * BOUNCINESS
            self.position.x = w / 2.0 + 1
            bounce = True
        elif x + w >= screen_width:
            self.speed.x = -self.speed.x * BOUNCINESS
            self.position.x = screen_width - w / 2.0 - 1
            bounce = True
 
        # 根据时间计算现在的位置
        # 正规的应该是“s = 1/2*g*t*t”，不过这样省事省时一点，咱只是模拟~
        self.position += self.speed * time_passed
        # 根据重力计算速度
        self.speed.y += time_passed * GRAVITY
 
        if bounce:
            self.play_bounce_sound()
 
        self.age += time_passed
 
    def play_bounce_sound(self):
        """这个就是播放声音的函数"""
        channel = self.bounce_sound.play()
 
        if channel is not None:
            # 设置左右声道的音量
            left, right = stero_pan(self.position.x, SCREEN_SIZE[0])
            channel.set_volume(left, right)
 
    def render(self, surface):
        w, h = self.image.get_size()
        x, y = self.position
        x -= w/2
        y -= h/2
        surface.blit(self.image, (x, y))
 
def run():
    # 上一次的内容
    #pygame.mixer.pre_init(44100, 16, 2, 1024*4)
    pygame.init()
    pygame.mixer.init(44100, 16, 2, 1024*4)
    pygame.mixer.set_num_channels(8)
    screen = pygame.display.set_mode(SCREEN_SIZE, 0)
 
    pygame.mouse.set_visible(False)
    clock = pygame.time.Clock()
 
    ball_image = pygame.image.load("ball.png").convert_alpha()
    mouse_image = pygame.image.load("mousecursor.png").convert_alpha()
 
    # 加载声音文件
    bounce_sound = pygame.mixer.Sound("bounce.ogg")
    balls = []
 
    while True:
        for event in pygame.event.get():
            if event.type == QUIT:
                return
            if event.type == MOUSEBUTTONDOWN:
                # 刚刚出来的小球，给一个随机的速度
                random_speed = ( randint(-400, 400), randint(-300, 0) )
                new_ball = Ball( event.pos,
                                 random_speed,
                                 ball_image,
                                 bounce_sound )
                balls.append(new_ball)
 
        time_passed_seconds = clock.tick() / 1000.
        screen.fill((255, 255, 255))
        # 为防止小球太多，把超过寿命的小球加入这个“死亡名单”
        dead_balls = []
        for ball in balls:
            ball.update(time_passed_seconds)
            ball.render(screen)
            # 每个小球的的寿命是10秒
            if ball.age > 10.0:
                dead_balls.append(ball)
        for ball in dead_balls:
            balls.remove(ball)
 
        mouse_pos = pygame.mouse.get_pos()
        screen.blit(mouse_image, mouse_pos)
        pygame.display.update()
 
if __name__ == "__main__":
    run()