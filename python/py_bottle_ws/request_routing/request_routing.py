#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from bottle import route, run, template


@route('/')
@route('/hello/<name>')
def greet(name='Stranger'):
    return template('Hello {{name}}, how are you?', name=name)


run(host='localhost', port=8080, debug=True)
