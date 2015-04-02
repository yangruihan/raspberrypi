#!/usr/bin/env python3
#coding:utf-8

import pickle
from athletelist import AthleteList

def get_coach_data(filename):
    try:
        with open(filename) as f:
            data = f.readline().strip().split(',')
            return (AthleteList(data.pop(0), data.pop(0), data))
    except IOError as io_err:
        print("The IOError*(get_coach_data) : " + str(io_err))
        return(None)

def put_to_store(files_list):
    all_athletes = {}
    for temp_file in files_list:
        all_athletes[temp_file.name] = temp_file
    try:
        with open('athletes.pickle', 'wb') as pk_file:
           pickle.dump(all_athletes, pk_file)
    except IOError as io_err:
        print("The IOError(put_to_store) : " + str(io_err))
    return (all_athletes)

def get_from_store(filename="athletes.pickle"):
    all_athletes = {}
    try:
        with open(filename, 'rb') as pk_file:
            all_athletes = pickle.load(pk_file)
    except IOError as io_err:
        print("The IOError(get_from_store) : " + str(io_err))
        return (None)
    return (all_athletes)
    

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

    all_athletes = [james, julie, mikey, sarah]
    res_list = put_to_store(all_athletes)
    print(res_list)

    
