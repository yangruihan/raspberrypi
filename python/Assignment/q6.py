from math import sin
from math import cos
from math import tan

while True:
    try:
        a = float(input('Input a(float): '))
        b = float(input('Input b(float): '))

        n = input('Input n(int): ')
        while '.' in n or '-' in n or '0' == n:
            n = input('Please input a positive integer n: ')
        n = int(n)

        f = input('Input function(sin|cos|tan): ')
        while f not in ['sin', 'cos', 'tan']:
            f = input('Input function(sin|cos|tan): ')

        if f == 'sin':
            f = sin
        elif f == 'cos':
            f = cos
        elif f == 'tan':
            f = tan

        result = 0.0
        for i in range(1, n + 1):
            c = (b - a) / n
            result += (c * f(a + c * (i - 0.5)))

        print('The result is %f\n' % result)

        break

    except Exception as e:
        print('Please input right value!')
