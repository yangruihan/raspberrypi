#!/usr/bin/env python3
# -*- coding:utf-8 -*-


import threading


# 创建一个全局 ThreadLocal 变量
local_student = threading.local()


def thread_func(name):
    local_student.student_name = name
    student_func()


def student_func():
    name = local_student.student_name
    print('Thread name: %s && Student name: %s' % (threading.current_thread().name, name))


if __name__ == '__main__':
    p1 = threading.Thread(target=thread_func, name='P1', args=('Alice',))
    p2 = threading.Thread(target=thread_func, name='P2', args=('Bob',))
    p1.start()
    p2.start()
    p1.join()
    p2.join()
