#-*- coding:utf-8 -*-

import random, string

def gen_rand_code(num, len):
    with open('result.txt', 'wb') as file:
        for i in range(num):
            chars = string.letters + string.digits
            s = [random.choice(chars) for i in range(length)]
            file.write(''.join(s) + '\n')

if __name__ == '__main__':
    number = raw_input('Write the number: ')
    length = raw_input('Write the length: ')
    gen_rand_code(int(number), int(length))