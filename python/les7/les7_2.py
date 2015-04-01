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
	sarah_dic = {}
	(sarah_dic['Name'], sarah_dic['Dob']) = sarah.pop(0), sarah.pop(0)
	sarah_dic['Times'] = sarah
	print(sarah_dic['Name'] + "'s fastest times are: " + str(sorted(set([sanitize(t) for t in sarah_dic['Times']]))[0:3]))





