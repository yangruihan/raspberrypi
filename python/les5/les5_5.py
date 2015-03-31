#!usr/bin/env python3
import nester
import pickle

try:
	with open('man_data.pickle', 'rb') as man_in, open('other_data.pickle', 'rb') as other_in:
		man_list = pickle.load(man_in)
		other_list = pickle.load(other_in)
except PickleError as err:
	print('pickle error: ' + str(err))
except IOError as io_err:
	print('IO error: ' + str(io_err))

nester.print_lol(man_list)
print('------------------------')
nester.print_lol(other_list)
