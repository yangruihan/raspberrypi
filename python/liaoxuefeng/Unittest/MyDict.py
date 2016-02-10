#!/usr/bin/env python3
# -*- coding:utf-8 -*-


class Dict(dict):
    def __init__(self, **kwargs):
        super().__init__(**kwargs)

    def __getattr__(self, item):
        try:
            return self[item]
        except KeyError:
            raise AttributeError(r"'Dict' object has no attribute '%s'" % item)

    def __setattr__(self, key, value):
        self[key] = value


if __name__ == '__main__':
    d = Dict(a=1, b=2)
    print(d.a)
    d.c = 3
    print(d.c)
