#!/usr/bin/env python3
# -*- coding:utf-8 -*-


from collections import namedtuple
from collections import deque
from collections import defaultdict
from collections import OrderedDict
from collections import Counter

# namedtuple
Point = namedtuple('Point', ['x', 'y'])
p = Point(1, 2)
print(p.x)
print(p.y)

# deque
q = deque(['a', 'b', 'c'])
q.append('x')
q.appendleft('y')
print(q)
q.pop()
print(q)
q.popleft()
print(q)

# default dict
dd = defaultdict(lambda: 'N/A')
dd['key1'] = '123'
print(dd['key1'])
print(dd['key2'])

# Ordered dict 有序字典
d = dict([('a', '1'), ('b', '2'), ('c', '3')])
print(d)
d = OrderedDict([('a', '1'), ('b', '2'), ('c', '3')])
print(d)

# Counter
c = Counter()
for ch in 'programming':
    c[ch] += 1
print(c)