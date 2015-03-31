#!usr/bin/env python3
import nester
import pickle

man = []
other = []

try:
	with open('sketch.txt') as the_file:
		for each_line in the_file:
			try:
				(role, line_spoken) = each_line.split(":", 1)
				line_spoken = line_spoken.strip() 
				if role == 'Man':
					man.append(line_spoken)
				elif role == 'Other Man':
					other.append(line_spoken)
			except ValueError:
				pass
except IOError as err:
	print('File error: ' + str(err))

try:
	#with open('man_data.txt', 'w') as man_out: 
	#	nester.print_lol(man, output=man_out)
	#with open('other_data.txt', 'w') as other_out:
	#	nester.print_lol(other, output=other_out)
	with open('man_data.pickle', 'wb') as man_out, open('other_data.pickle', 'wb') as other_out:
		pickle.dump(man, man_out)
		pickle.dump(other, other_out)

except PickleError as err:
	print('File error: ' + str(err))
