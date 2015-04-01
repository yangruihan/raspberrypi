#!/usr/bin/env python3

def open_file(filename):
	try:
		with open(filename) as temp_file:
			return(temp_file.readline().strip().split(','))
	except IOError as io_er:
		print('IOError: ' + str(io_err))
		return(None)

james = open_file('james.txt')
julie = open_file('julie.txt')
mikey = open_file('mikey.txt')
sarah = open_file('sarah.txt')

def sanitize(time_string):
	if '-' in time_string:
		splitter = '-'
	elif ':' in time_string:
		splitter = ':'
	else:
		return(time_string)
	(mins, secs) = time_string.split(splitter)
	return(mins + '.' + secs)

print(sorted(set([sanitize(each_item) for each_item in james]))[0:3])
print(sorted(set([sanitize(each_item) for each_item in julie]))[0:3])
print(sorted(set([sanitize(each_item) for each_item in mikey]))[0:3])
print(sorted(set([sanitize(each_item) for each_item in sarah]))[0:3])

