#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from bottle import error, route, run


@route('/index')
def index():
    return 'Hello'


@error(404)
def error404(error):
    return 'No page found!'


run(host='localhost', port=8080, debug=True)
