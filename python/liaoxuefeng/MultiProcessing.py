#!/usr/bin/env python
# -*- coding:utf-8 -*-


import os
import random
import time
from multiprocessing import Pool
from multiprocessing import Process


# use fork
def use_fork():
    print('Process (%s) start' % os.getpid())
    pid = os.fork()
    if pid == 0:
        print("I'm child process (%s) and my parent is %s." % (os.getpid(), os.getppid()))
    else:
        print("I'm father process (%s) and my child is %s." % (os.getpid(), pid))


# use multiprocessing Process
def use_process():
    def run_proc(name):
        print('Run child process %s (%s)' % (name, os.getpid()))

    print('Parent process %s.' % os.getpid())
    p = Process(target=run_proc, args=('test',))
    print('Child process will start.')
    p.start()
    p.join()
    print('Child process end.')


# use process pool
def long_time_task(name):
    print('Run task %s (%s)' % (name, os.getpid()))
    start = time.time()
    time.sleep(random.random() * 3)
    end = time.time()
    print('Task %s runs %0.2f seconds.' % (name, (end - start)))

print('Parent process %s.' % os.getpid())
p = Pool(4)
for i in range(5):
    p.apply_async(long_time_task, args=(i,))
print('Waiting for all sub processes done...')
p.close()
p.join()
print('All sub processes done.')


