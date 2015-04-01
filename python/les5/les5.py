#!/usr/bin/env python3

man = []
other = []

try:
	the_file = open('sketch.txt')

	the_file.seek(0)
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
finally:
	if 'the_file' in locals():
		the_file.close()

try:
	man_out = open('man_data.txt', 'w')
	other_out = open('other_data.txt', 'w')

	print(man, file=man_out)
	print(other, file=other_out)

	man_out.close()
	other_out.close()
except IOError as err:
	print('File error: ' + str(err))
finally:
	if 'man_out' in locals():
		man_out.close()
	if 'other_out' in locals():
		other_out.close()
