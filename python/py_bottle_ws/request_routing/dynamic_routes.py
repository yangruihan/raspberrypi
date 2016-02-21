#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from bottle import route, run


@route('/email/<email:re:[\w_]+@\w+.com>')
def callback(email):
    return 'Your email address: ' + email


@route('/path/<path:path>')
def printpath(path):
    return 'Your path: ' + path


run(host='localhost', port=8080, debug=True)
