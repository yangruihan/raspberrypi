#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from bottle import route, static_file, run


@route('/static/<filename>')
def server_static(filename):
    return static_file(filename, root='./img/')


run(host='localhost', port=8080, debug=True)
