#!/usr/bin/env python3
# -*- coding:utf-8 -*-


class ListMetaclass(type):
    def __new__(cls, name, base, attrs):
        attrs['add'] = lambda self, value: self.append(value)
        return type.__new__(cls, name, base, attrs)


class MyList(list, metaclass=ListMetaclass):
    pass


if __name__ == '__main__':
    L = MyList()
    L.add(1)
    print(L)
