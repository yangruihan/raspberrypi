#!/usr/bin/env python3
import os

if os.path.exists('sketch.txt'):
	the_file = open('sketch.txt')

	print(the_file.readline(), end='')
	print(the_file.readline(), end='')

	the_file.seek(0)
	for each_line in the_file:
		if not each_line.find(":") == -1:
			(role, line_spoken) = each_line.split(":", 1)
			print(role, end='')
			print(' said: ', end='')
			print(line_spoken, end='')
		else:
			print(each_line, end='')

	the_file.close()

else:
	print("The data file is missing!")
