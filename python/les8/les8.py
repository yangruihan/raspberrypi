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

class Athlete:
    def __init__(self, a_name, a_dob=None, a_times=[]):
        self.name = a_name
        self.dob = a_dob
        self.times = a_times

    def top3(self):
        return (sorted(set([sanitize(t) for t in self.times]))[0:3])

    def show_top3(self):
        print(self.name + "'s fastest times are: " + str(self.top3()))

    def add_time(self, time_value):
        self.times.append(time_value)
        
    def add_times(self, time_values):
        if (isinstance(time_values, list)):
            self.times.extend(time_values)
        else:
            print('list is wrong')

def get_coach_data(filename):
    try:
        with open(filename) as f:
            data = f.readline().strip().split(',')
            return (Athlete(data.pop(0), data.pop(0), data))
    except IOError as io_err:
        print("The IOError : " + str(io_err))
        return(None)

if __name__ == '__main__':
    james = get_coach_data('james2.txt')
    julie = get_coach_data('julie2.txt')
    mikey = get_coach_data('mikey2.txt')
    sarah = get_coach_data('sarah2.txt')

    james.show_top3()
    julie.show_top3()
    mikey.show_top3()
    sarah.show_top3()

    print('------------------------------')

    james.add_times(['1.00', '1.23'])
    james.show_top3()
