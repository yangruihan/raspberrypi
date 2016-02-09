#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import functools

def log(*arg):
    def decorator(func=arg[0]):
        @functools.wraps(func)
        def wrapper(*args, **kw):
            text = arg[0] if isinstance(arg[0], str) else 'call'
            print('begin %s' % text)
            f = func(*args, **kw)
            print('end %s' % text)
            return f
        return wrapper
    return decorator() if callable(*arg) else decorator

@log
def now():
    print('2016-2-9')

@log('execute')
def yes():
    print('yes')

now()
yes()