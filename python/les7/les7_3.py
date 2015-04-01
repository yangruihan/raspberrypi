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
			data = f.readline().strip().split(',')
		return({'Name'		:	data.pop(0),
				'Dob'		:	data.pop(0),
				'Fast_times' :	sorted(set([sanitize(t) for t in data]))[0:3]})
	except IOError as io_err:
		print("The IOError : " + io_err)
		return(None)

if __name__ == '__main__':
	sarah_dic = get_coach_data('sarah2.txt')
	print(sarah_dic['Name'] + "'s fastest times are: " + str(sarah_dic['Fast_times']))




