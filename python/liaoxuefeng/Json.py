#!/usr/bin/env python3
# -*- coding:utf-8 -*-


import json


class Person(object):
    def __init__(self, name, age, gender):
        self.name = name
        self.age = age
        self.gender = gender

    def __str__(self):
        return 'Name:%s Age:%s Gender:%s' % (self.name, self.age, self.gender)


def person2dict(p):
    return {
        'name': p.name,
        'age': p.age,
        'gender': p.gender
    }


def dict2person(d):
    return Person(d['name'], d['age'], d['gender'])


if __name__ == '__main__':
    p = Person('小明', 16, '男')

    json_str = json.dumps(p, default=person2dict)
    p = json.loads(json_str, object_hook=dict2person)
    print(p)
