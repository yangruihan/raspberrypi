#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# 正则表达式

# 1,精准匹配：在正则表达式中，如果直接给出字符，就是精准匹配
#
# 2.模糊匹配：
#  (1) \d 匹配一个数字
#  (2) \w 匹配一个字母或数字
# 例：
#   '00\d' 可以匹配 '007'
#   '\d\d\d' 可以匹配 '010'
#   '\w\w\d' 可以匹配 'py3'
#
#  (3) . 匹配任意字符
# 例：
#   'py.' 可以匹配 'pyc'、'pyo'、'py!'
#
#  (4) * 匹配任意个字符（包括0个）
#  (5) + 匹配至少一个字符
#  (6) ? 表示0个或1个字符
#  (7) {n} 表示n个字符
#  (8) {n, m} 表示n-m个字符
#  (9) \s 匹配一个空格（也包括Tab等空白符）
# 例：
#   '\d{3}\s+\d{3, 8}'
#   分析：
#       \d{3} 表示匹配3个数字
#       \s+ 表示至少有一个空格
#       \d{3, 8} 表示匹配3-8个数字
#
# 注意：在匹配中有些符号需要用'\'转义，如：\- \' 等
#
# 更精准的模糊匹配：
#  (1) 使用 [] 表示范围
#   例：
#       [0-9a-zA-Z\_] 可以匹配一个数字、字母或者下划线
#       [0-9a-zA-Z\_]+ 可以匹配至少由一个数字、字母或者下划线组成的字符串
#       [a-zA-Z\_][0-9a-zA-Z\_]* 可以匹配由一个字母或下划线开头的后接任意个字母数字下划线组成的字符串，即合法变量名
#       [a-zA-Z\_][0-9a-zA-Z\_]{0-19} 更精确地限定了变量的长度为1-20个字符
# 
#  (2) A|B 可以匹配A或者B
#   例：
#       [P|p]ython 可以匹配 'python' 或 'Python'
#
#  (3) ^ 表示行的开头
#   例：
#       ^\d 表示必须以数字开头
#
#  (4) $ 表示行的结束
#   例：
#       \d$ 表示必须以数字结束
#
# 注意：由于python字符串本身也用到了转义，因此：
#   s = 'ABC\\-001' 
#   等同于正则表达式字符串：'ABC\-001'
#   因此如果使用 r'ABC\-001' 则无需考虑此问题
#
# 3.分组
#   () 可以对字符串进行分组
#   例:
#       ^(\d{3})-(\d{3, 8})$
#   m = re.match(r'^(\d{3})-(\d{3, 8})$', '010-123456')
#   print(m.group(0)) # 输出'010-123456'
#   print(m.group(1)) # 输出'010'
#   print(m.group(2)) # 输出'123456'
#
# 注意：正则表达式在匹配的时候默认是贪婪匹配，即尽可能多的匹配符合要求的字符
#   例：
#       re.match(r'^(\d+)(0*)$', '102400').groups()
#       # 结果为('102400', '')
#   由于采取贪婪匹配，\d+ 就把所有的数字给匹配完了，后面的0*没有任何作用
#   有时候不希望这种匹配方式，则可以加一个?
#   例：
#       re.match(r'^(\d+?)(0*)$', '102400').groups()
#       # 结果为('1024', '00')
#
# 在使用正则表达式的时候，可以预编译正则表达式来优化频繁使用的正则表达式的效率
#   例：
#       re_telephone = re.compile(r'^(\d{3})-(\d{3, 8})$')
#       re_telephone.match('010-123456').groups()
#       # 结果仍为('010', '123456')


import re

## 正则表达式匹配演示
#test = raw_input()
#if re.match(r'^[a-zA-Z\_][0-9a-zA-Z\_]*$', test):
#    print('ok')
#else:
#    print('failed')
#
## 正则表达式切分字符串演示
#test = 'a b    c   d  e' # b c d e 之间分别不止一个空格
#print('传统方法: ', test.split(' '))
#print('正则表达式方法:', re.split(r'\s+', test))
#
#test = 'a,b, c , d'
#print(re.split(r'[\,\s]+', test))

email = raw_input('Please input a email address:')
re_email = re.compile(r'^([a-zA-Z\_][a-zA-Z0-9\_\.]*)@([a-zA-Z\_][a-zA-Z0-9\_\.]+?).(com|cn|org)$')

print (email)

if (re_email.match(email)):
    print ('ok')
    print (re_email.match(email).groups())
else:
    print ('failed')

email = raw_input('Please input a email address2:')
re_email = re.compile(r'\<([A-Za-z\_\s]+)\>\s+([a-zA-Z\_][a-zA-Z0-9\_\.]*)@([a-zA-Z\_][a-zA-Z0-9\_\.]+?).(com|cn|org)$')

if (re_email.match(email)):
    print ('ok')
    print (re_email.match(email).groups())
else:
    print ('failed')
