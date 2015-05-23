#!/usr/bin/env python
# -*- coding:utf-8 -*-

__author__ = 'Yrh'

import pygame
import util

_SOUNDS = {}


def load():
    global _SOUNDS
    # play background music
    pygame.mixer.pre_init()
    pygame.init()
    pygame.mixer.music.load(util.file_path('background.ogg'))
    pygame.mixer.music.play(-1)  # loop play

    for i in ('1', '2', '3', '4', 'drop', 'menu'):
        _SOUNDS[i] = pygame.mixer.Sound(util.file_path(i + '.ogg'))

def play_sound(name):
    try:
        _SOUNDS[name].play
    except KeyError:
        pass