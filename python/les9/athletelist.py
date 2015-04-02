#!/usr/bin/env python3
#coding:utf-8

def sanitize(time_string):
    if '-' in time_string:
        spliter = '-'
    elif ':' in time_string:
        spliter = ':'
    else:
        return(time_string)
    (mins, secs) = time_string.split(spliter)
    return(mins+'.'+secs)

class AthleteList(list):
    def __init__(self, a_name, a_dob, a_times):
        list.__init__([])
        self.name = a_name
        self.dob = a_dob
        self.extend(a_times)

    def top3(self):
        return (sorted(set([sanitize(f) for f in self]))[0:3])

    def show_top3(self):
        print(self.name + "'s fastest times are : " + str(self.top3()))
