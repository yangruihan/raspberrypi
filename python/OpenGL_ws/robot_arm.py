#!/usr/bin/env python3
# -*- coding:utf-8 -*-

from OpenGL.GL import *
from OpenGL.GLU import *
from OpenGL.GLUT import *

shoulder_x = 0 # 控制大臂绕x轴旋转
shoulder_y = 0 # 控制大臂绕y轴旋转
shoulder_z = 0 # 控制大臂绕z轴旋转
elbow = 0 # 控制小臂旋转
wrist = 0 # 控制手腕旋转

def init():
    glClearColor(0, 0, 0, 0)
    # 设置着色模式
    glShadeModel(GL_FLAT) # 采用恒定着色时，使用图元中某个顶点的颜色来渲染整个图元

def reshape(w, h):
    # 设置视口
    glViewport(0, 0, GLsizei(w), GLsizei(h))
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    # 设置透视阴影
    gluPerspective(75, w / h, 1, 20)
    glMatrixMode(GL_MODELVIEW)
    glLoadIdentity()
    glTranslatef(0, 0, -5) # 为了能看到投影，将 z=0 平面上的图形移到视景体观察

def display():

    global shoulder_x

    glClear(GL_COLOR_BUFFER_BIT)
    glPushMatrix() # 保留单位矩形

    # 控制大手臂
    glTranslatef(-1, 0, 0)
    glRotatef(GLfloat(shoulder_x), 0, 0, 1) # 大臂x轴旋转
    glTranslatef(1, 0, 0)

    glTranslatef(-1, 0, 0)
    glRotatef(GLfloat(shoulder_y), 1, 0, 0) # 大臂y轴旋转
    glTranslatef(1, 0, 0)

    glTranslatef(-1, 0, 0)
    glRotatef(GLfloat(shoulder_z), 0, 1, 0) # 大臂z轴旋转
    glTranslatef(1, 0, 0)

    glPushMatrix() # 保留矩阵 T1=T(-)R(shoulder_x)T(+)
                   # 绕固定点 (-1, 0, 0)
                   # 然后中心回到原点

    glScalef(2, 0.4, 1) # 缩放大手臂
    glutWireCube(1.0) # 绘制大手臂
    glPopMatrix() # 恢复矩阵 T(-)RT(+)
                  # 使它同时作用于小手臂

    # 控制小手臂，同时受到两个旋转参数的控制：shoulder_x、elbow
    glTranslatef(1, 0, 0)
    glRotatef(GLfloat(elbow), 0, 0, 1)
    glTranslatef(1, 0, 0) # 矩阵 T2=T(+)R(elbow)T(+)
                          # 绕固定点 (1, 0, 0) 公转，且中心移到 (2, 0, 0)
                          # 此时的矩阵是 T=T1T2

    glPushMatrix()
    glScalef(2, 0.4, 1)
    glutWireCube(1) # 画小手臂
    glPopMatrix()

    # 控制手腕
    glTranslatef(1, 0, 0)
    glRotatef(GLfloat(wrist), 0, 0, 1)
    glTranslatef(1, 0, 0)

    glPushMatrix()
    glScalef(2, 0.1, 0.25) 
    glutWireCube(1) # 画手腕
    glPopMatrix()

    glPopMatrix()


    # 画出参考点
    glPointSize(5)
    glBegin(GL_POINTS)
    glVertex3f(-1, 0, 0)
    glVertex3f(0, 0, 0)
    glVertex3f(1, 0, 0)
    glVertex3f(2, 0, 0)
    glVertex3f(3, 0, 0)
    glVertex3f(4, 0, 0)
    glEnd()

    glutSwapBuffers()


def keyboard(key, x, y):

    global shoulder_x, shoulder_y, shoulder_z, elbow, wrist

    print('shoulder_x: %s, shoulder_y: %s, shoulder_z: %s, elbow: %s, wrist: %s' % (shoulder_x, shoulder_y, shoulder_z, elbow, wrist))

    # s 键大手臂绕x轴逆时针旋转
    if key == b's':
        shoulder_x = (shoulder_x + 5) % 360
        glutPostRedisplay()
    elif key == b'S':
        shoulder_x = (shoulder_x - 5) % 360
        glutPostRedisplay()

    # d 键大手臂绕y轴旋转
    elif key == b'd':
        if shoulder_y >= 90:
            return
        else:
            shoulder_y += 5
        glutPostRedisplay()
    elif key == b'D':
        if shoulder_y <= -90:
            return
        else:
            shoulder_y -= 5
        glutPostRedisplay()

    # f 键大手臂绕z轴旋转
    elif key == b'f':
        if shoulder_z >= 90:
            return
        else:
            shoulder_z += 5
        glutPostRedisplay()
    elif key == b'F':
        if shoulder_z <= -90:
            return
        else:
            shoulder_z -= 5
        glutPostRedisplay()

    # e 键小手臂绕x轴旋转
    elif key == b'e':
        elbow = (elbow + 5) % 360
        glutPostRedisplay()
    elif key == b'E':
        elbow = (elbow - 5) % 360
        glutPostRedisplay()

    # g 键手腕绕x轴旋转
    elif key == b'g':
        if wrist >= 90:
            return
        else:
            wrist += 5
        glutPostRedisplay()
    elif key == b'G':
        if wrist <= -90:
            return
        else:
            wrist -= 5
        glutPostRedisplay()

    # h 键三个联动
    elif key == b'h':
        shoulder_x = (shoulder_x + 5) % 360
        elbow = (elbow + 5) % 360
        wrist = (wrist + 5) % 360
        glutPostRedisplay()
    elif key == b'H':
        shoulder_x = (shoulder_x - 5) % 360
        elbow = (elbow - 5) % 360
        wrist = (wrist - 5) % 360
        glutPostRedisplay()
    elif key == 27:
        exit(0)

def main():
    glutInit()
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB)
    glutInitWindowSize(500, 500)
    glutInitWindowPosition(100, 100)
    glutCreateWindow(None)
    init()
    glutDisplayFunc(display)
    glutReshapeFunc(reshape)
    glutKeyboardFunc(keyboard)
    glutMainLoop()

if __name__ == '__main__':
    main()