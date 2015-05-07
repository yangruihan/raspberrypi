#!/usr/bin/python
#-*- coding:utf-8 -*-

from PIL import Image, ImageDraw, ImageFont
import os

def add_num(inputImageName, outputImageName, drawNum):
    img = Image.open(inputImageName)

    draw = ImageDraw.Draw(img) #获取图像信息
    width, height = img.size #获取图像长宽
    myfont = ImageFont.truetype('MONACO.TTF', size = width / 5) #获取字体信息
    fillcolor = "#ff0000" #获取颜色信息 ff0000 代表红色
    draw.text((width - width / 5 - 10, 5), drawNum, font = myfont, fill = fillcolor) #写字
    img.save(outputImageName, 'jpeg') #保存图片

    return 0

if __name__ == '__main__':
    inputImageName = raw_input('Input image file name: ')
    while (not os.path.exists(inputImageName)):
        inputImageName = raw_input('Input RIGHT image file name: ')
    
    outputImageName = raw_input("Output image file name: ")

    if not ('.jpg' in outputImageName):
        outputImageName = outputImageName + '.jpg'

    drawNum = raw_input('Write a number to draw: ')

    print(inputImageName)
    print(outputImageName)
    print(drawNum)
    
    image = Image.open(inputImageName)
    add_num(inputImageName, outputImageName, drawNum)    
