#!usr/bin/env python3
import nester

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
	with open('man_data.txt', 'w') as man_out: 
		nester.print_lol(man, output=man_out)
	with open('other_data.txt', 'w') as other_out:
		nester.print_lol(other, output=other_out)
	#with open('man_data.txt', 'w') as man_out, with open('other_data.txt', 'w') as other_out:
		#print(man, file=man_out)
		#print(other, file=other_out)

except IOError as err:
	print('File error: ' + str(err))
