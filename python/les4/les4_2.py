#!/usr/bin/env python3

try:
	the_file = open('sketch.txt')

	print(the_file.readline(), end='')
	print(the_file.readline(), end='')

	the_file.seek(0)
	for each_line in the_file:
		try:
			(role, line_spoken) = each_line.split(":", 1)
			print(role, end='')
			print(' said: ', end='')
			print(line_spoken, end='')
		except ValueError:
			print(each_line, end='')

	the_file.close()
except IOError:
	print("The data file is missing!")
