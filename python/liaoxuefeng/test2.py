def fn(self, name='world'):
    print('Hello, %s.' % name)

Hello = type('Hello', (object,), dict(hello=fn)) #动态创建Hello类
h = Hello()
h.hello()
print(type(Hello))
print(type(h))
