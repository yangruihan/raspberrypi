#!usr/bin/env python3

fav_movies = ["The Holy Grail", "The Life of Brain"]

for each_flick in fav_movies:
	print (each_flick)

count = 0
while count < len(fav_movies):
	print (fav_movies[count])
	count = count + 1
	
print ("---------------")

movies = ["The Holy Grail", 1975, "Terry Jones & Terry Gilliam", 91,
			["Graham Chapman",
				["Michael Palin", "John Cleese", "Terry Gilliam", "Eric Idle", "Terry Jones"]]]
print (movies)

print ("---------------")

for each_flick in movies:
	if isinstance(each_flick, list):
		for each_item in each_flick:
			if isinstance(each_item, list):
				for deeper_item in each_item:
					print (deeper_item)
			else:
				print (each_item)
	else:
		print (each_flick)

print ("---------------")

def print_lol(the_list):
	for each_flick in the_list:
		if (isinstance(each_flick, list)):
			print_lol(each_flick)
		else:
			print(each_flick)

print_lol(movies)

print ("---------------")
