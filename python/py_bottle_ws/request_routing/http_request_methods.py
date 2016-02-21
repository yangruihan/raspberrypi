#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from bottle import get, post, request, run


@get('/login')  # or @route('/login')
def login():
    return '''
        <meta content-Type="text/html" charset="utf-8"/>
        <form name="loginForm" action="/login" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    '''


@post('/login')  # or @route('/login', method='POST')
def do_login():
    username = request.forms.get('username')
    password = request.forms.get('password')
    return 'Your username is ' + username + '<br>Your password is ' + password


run(host='localhost', port=8080, debug=True)
