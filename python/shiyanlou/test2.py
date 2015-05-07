#!/usr/bin/env python3

def line_conf():
	b = 15
	def line(x):
		return 2*x+b
	return line 

b = 5
my_line = line_conf()
print(my_line(5))
print('-----')
print(my_line.__closure__)
print(my_line.__closure__[0].cell_contents)
