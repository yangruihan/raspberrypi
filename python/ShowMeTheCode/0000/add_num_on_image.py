#-*- coding:utf-8 -*-

from PIL import Image, ImageDraw, ImageFont
import os

def add_num(inputImageName, outputImageName, drawNum):
    draw = ImageDraw.Draw(img) #获取图像信息
    myfont = ImageFont.truetype('C:/windows/fonts/Arial.ttf', size = 40) #获取字体信息
    fillcolor = "#ff0000" #获取颜色信息 ff0000 代表红色
    width, height = img.size #获取图像长宽
    draw.text((width - 45, 5), drawNum, font = myfont, fill = fillcolor) #写字
    img.save(outputImageName, 'jpeg') #保存图片

    return 0

if __name__ == '__main__':
    inputImageName = raw_input('Input image file name: ')
    while !os.path.exists(inputImageName):
        inputImageName = raw_input('Input RIGHT image file name: ')
    
    outputImageName = raw_input('Output image file name(Default:'result.jpg'): ')
    if outputImageName == 13:
        outputImageName = 'result.jpg'

    if !('.jpg' in outputImageName):
        outputImageName = outputImageName + '.jpg'

    drawNum = raw_input('Write a number to draw: ')
    
    image = Image.open(inputImageName)
    add_num(inputImageName, outputImageName, drawNum)    