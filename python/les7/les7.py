#!/usr/bin/env python3

def sanitize(time_string):
	if '-' in time_string:
		spliter = '-'
	elif ':' in time_string:
		spliter = ':'
	else:
		return(time_string)
	(mins, secs) = time_string.split(spliter)
	return(mins+'.'+secs)

def get_coach_data(filename):
	try:
		with open(filename) as f:
			data = f.readline()
		return(data.strip().split(','))
	except IOError as io_err:
		print("The IOError : " + io_err)
		return(None)

if __name__ == '__main__':
	sarah = get_coach_data('sarah2.txt')
	(sarah_name, sarah_dob) = sarah.pop(0), sarah.pop(0)
	print(sarah_name + "'s fastest times are: " + str(sorted(set([sanitize(t) for t in sarah]))[0:3]))



