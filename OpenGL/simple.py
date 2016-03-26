from OpenGL.GL import *
from OpenGL.GLU import *
from OpenGL.GLUT import *

def display():
    glClear(GL_COLOR_BUFFER_BIT)
    glBegin(GL_QUADS)
    glVertex2d(-0.5, -0.5)
    glVertex2d(-0.5, 0.5)
    glVertex2d(0.5, 0.5)
    glVertex2d(0.5, -0.5)
    glEnd()
    glFlush()

glutInit()
glutCreateWindow("Simple")
glutDisplayFunc(display)
glutMainLoop()
