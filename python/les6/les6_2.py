#!/usr/bin/env python3

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

#def replace_list(time_list):
#	result_list = []
#	for each_item in time_list:
#		result_list.append(sanitize(each_item))
#	return(result_list)	

ja_so = sorted([sanitize(each_item) for each_item in james]) 
ju_so = sorted([sanitize(each_item) for each_item in julie]) 
mi_so = sorted([sanitize(each_item) for each_item in mikey]) 
sa_so = sorted([sanitize(each_item) for each_item in sarah]) 

#print(ja_so)
#print(ju_so)
#print(mi_so)
#print(sa_so)

#def delet_repe(time_list):
#	result_list = []
#	for each_item in time_list:
#		if each_item not in result_list:
#			result_list.append(each_item)
#	return result_list	
#
#unique_james = delet_repe(ja_so)
#unique_julie = delet_repe(ju_so)
#unique_mikey = delet_repe(mi_so)
#unique_sarah = delet_repe(sa_so)
#
#print(unique_james[0:3])
#print(unique_julie[0:3])
#print(unique_mikey[0:3])
#print(unique_sarah[0:3])

print(sorted(set(ja_so))[0:3])
print(sorted(set(ju_so))[0:3])
print(sorted(set(mi_so))[0:3])
print(sorted(set(sa_so))[0:3])







