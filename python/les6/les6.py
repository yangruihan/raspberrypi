#!usr/bin/env python3

try:
	with open('james.txt') as ja_file, open('julie.txt') as ju_file, open('mikey.txt') as mi_file, open('sarah.txt') as sa_file:
		james = ja_file.readline().strip().split(',')	
		julie = ju_file.readline().strip().split(',')
		mikey = mi_file.readline().strip().split(',')
		sarah = sa_file.readline().strip().split(',')
	
except IOError as io_err:
	print('IOError: ' + str(io_err))

#print(james)
#print(julie)
#print(mikey)
#print(sarah)

def sanitize(time_string):
	if '-' in time_string:
		splitter = '-'
	elif ':' in time_string:
		splitter = ':'
	else:
		return(time_string)
	(mins, secs) = time_string.split(splitter)
	return(mins + '.' + secs)

def replace_list(time_list):
	result_list = []
	for each_item in time_list:
		result_list.append(sanitize(each_item))
	return(result_list)	

ja_so = sorted(replace_list(james))
ju_so = sorted(replace_list(julie))
mi_so = sorted(replace_list(mikey))
sa_so = sorted(replace_list(sarah))

print(ja_so)
print(ju_so)
print(mi_so)
print(sa_so)


