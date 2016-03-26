from OpenGL.GL import *
from OpenGL.GLU import *
from OpenGL.GLUT import *

import random

def display():
    vertices = [[0.0, 0.0], [25.0, 50.0], [50.0, 0.0]]
    p = [7.5, 5.0]
    glClear(GL_COLOR_BUFFER_BIT)
    glBegin(GL_POINTS)
    for i in range(500000):
        j = random.randint(0, 2)
        p[0] = (p[0] + vertices[j][0]) / 2.0
        p[1] = (p[1] + vertices[j][1]) / 2.0
        glVertex2fv(p)
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
