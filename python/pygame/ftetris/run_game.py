#!/usr/bin/env python

import sys, os

try:
    libdir = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'lib')
    sys.path.insert(0, libdir)
except:
    # in py2exe, __file__ is gone...
    sys.path.insert(0, os.path.join(sys.path[0], "lib"))
    pass

import game
game.run()
