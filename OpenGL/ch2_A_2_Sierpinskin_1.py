from OpenGL.GL import *
from OpenGL.GLU import *
from OpenGL.GLUT import *

vertices = [[0.0, 0.0], [25.0, 50.0], [50.0, 0.0]]
n = 6

def triangle(a, b, c):
    glVertex2fv(a)
    glVertex2fv(b)
    glVertex2fv(c)

def divide_triangle(a, b, c, k):
    ab = []
    ac = []
    bc = []
    if k > 0:
        for i in range(2):
            ab.append((a[i] + b[i]) / 2.0)
            ac.append((a[i] + c[i]) / 2.0)
            bc.append((b[i] + c[i]) / 2.0)

        divide_triangle(a, ab, ac, k - 1)
        divide_triangle(c, ac, bc, k - 1)
        divide_triangle(b, bc, ab, k - 1)
    else:
        triangle(a, b, c)

def display():
    glClear(GL_COLOR_BUFFER_BIT)
    glBegin(GL_TRIANGLES)
    divide_triangle(vertices[0], vertices[1], vertices[2], n)
    glEnd()
    glFlush()

def init():
    glClearColor(1.0, 1.0, 1.0, 1.0)
    glColor3f(1.0, 0.0, 0.0)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    gluOrtho2D(0.0, 50.0, 0.0, 50.0)
    glMatrixMode(GL_MODELVIEW)

glutInit()
glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB)
glutInitWindowSize(500, 500)
glutInitWindowPosition(0, 0)
glutCreateWindow("Sierpinski Gasket")
glutDisplayFunc(display)
init()
glutMainLoop()
