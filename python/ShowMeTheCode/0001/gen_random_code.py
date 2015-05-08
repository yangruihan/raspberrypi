#-*- coding:utf-8 -*-
#做为 Apple Store App 独立开发者，你要搞限时促销，为你的应用生成激活码（或者优惠券），使用 Python 如何生成 200 个激活码（或者优惠券）

import random, string

def gen_rand_code(num, len):
	with open('result.txt', 'wb') as file:
		for i in range(num):
			chars = string.letters + string.digits
			s = [random.choice(chars) for i in range(len)]
			#file.write(''.join(s) + '\n')
			file.write(''.join(s) + '\n')

if __name__ == '__main__':
	#number = raw_input('Write the number: ')
	#length = raw_input('Write the length: ')
	gen_rand_code(200, 8)