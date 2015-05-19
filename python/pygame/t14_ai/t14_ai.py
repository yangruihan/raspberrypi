#!/usr/bin/env python
#-*- coding:utf-8 -*-

import pygame
from pygame.locals import *
from sys import exit
from gameobjects.vector2 import Vector2
from math import *

#游戏实体类
class GameEntity(object):
	def __init__(self, world, name, image):
		self.world = world
		self.name = name
		self.image = image
		self.location = Vector2(0, 0)
		self.destination = Vector2(0, 0)
		self.speed = 0.
		self.brain = StateMachine()
		self.id = 0
	def render(self, surface):
		x, y = self.location
		w, h = self.image.get_size()
		surface.blit(self.image,(x - w / 2, y - h /2))
	def process(self, time_passed):
		self.brain.think()
		if self.speed > 0 and self.location != self.destination:
			vec_to_destination = self.destination - self.location
			distance_to_destination = vec_to_destination.get_length()
			heading = vec_to_destination.get_normalized()
			travel_distance = min(distance_to_destination, time_passed * self.speed)
			self.location += travel_distance * heading

#世界类
class World(object):
	def __init__(self):
		self.entities = {} # 存放所有的实体
		self.entity_id = 0 # 最后一个实体的id号
		self.background = pygame.surface.Surface(SCREEN_SIZE).convert()
		self.background.fill((255, 255, 255))
		pygame.draw.circle(self.background, (200, 255, 200), NEST_POSITION, INT(NEST_SIZE))

	# 增加实体方法
	def add_entity(self, entity):
		self.entities[self.entity_id] = entity
		entity.id = self.entity_id
		self.entity_id += 1

	# 删除实体
	def remove_entity(self, entity):
		del self.entities[entity.id]

	# 通过id 返回该 id 的实体，如没有返回Node
	def get(self, entity_id):
		if entity_id in self.entities:
			return self.entities[entity_id]
		else:
			return None

	# 处理世界中的每一个实体
	def process(self, time_passed):
		time_passed_seconds = time_passed / 1000.0
		for entity in self.entities.values():
			entity.process(time_passed_seconds)

	# 绘制背景和每一个实体
	def render(self, surface):
		surface.blit(self.background, (0, 0))
		for entity in self.entities.values():
			entity.render(surface)

	# 通过一个范围寻找之内的所有实体
	def get_close_entity(self, name, location ,range = 100.):
		location = Vector2(*location)
		for entity in self.entities.values():
			if entity.name == name:
				distance = location.get_distance_to(entity.location)
				if distance < range:
					return entity
		return None

# 蚂蚁类实例
class Ant(GameEntity):
	def __init__(self, world, image):
		# 调用基类的构造方法
		GameEntity.__init__(self, world, 'ant', image)
		# 创建各种状态
		exploring_state = AntStateExploring(self)
		seeking_state = AntStateSeeking(self)
		delivering_state = AntStateDelivering(self)
		hunting_state = AntStateHunting(self)
		self.brain.add_state(exploring_state)
		self.brain.add_state(seeking_state)
		self.brain.add_state(delivering_state)
		self.brain.add_state(hunting_state)
		self.carry_image = None

	def carry(self, image):
		self.carry_image = image

	# 放下carry时的图像
	def drop(self, surface):
		if self.carry_image:
			x, y = self.location
			w, h = self.carry_image.get_size()
			surface.blit(self.carry_image, (x - w / 2, y - h / 2))
			self.carry_image = None

	def render(self surface):
		GameEntity.render(self, surface)
		if self.carry_image:
			x, y = self.location
			w, h = self.carry_image.get_size()
			surface.blit(self.carry_image, (x - w / 2, y - h / 2))

# 状态基类
class State(object):
	def __init__(self, name):
		self.name = name

	def do_actions(self):
		pass

	def check_conditions(self):
		pass

	def entry_actions(self):
		pass

	def exit_actions(self):
		pass

# 状态机类
class StateMachine(object):
	def __init__(self):
		self.states = {} # 存储各种状态
		self.active_state = Node # 当前有效状态

	# 增加状态
	def add_state(self, state):
		self.states[state.name] = state

	# 思考
	def think(self):
		if self.active_state is None:
			return
		# 执行有效的操作，并做转移检查
		self.active_state.do_actions()
		new_state_name = self.active_state.check_conditions()
		if new_state_name is not None:
			self.set_state(new_state_name)

	# 设置状态
	def set_state(self, new_state_name):
		if self.active_state is not None:
			self.active_state.exit_actions()
		self.active_state = self.states[new_state_name]
		self.active_state.entry_actions()


