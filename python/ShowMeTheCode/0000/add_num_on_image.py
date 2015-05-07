#-*- coding:utf-8 -*-

from PIL import Image, ImageDraw, ImageFont
import os

def add_num(inputImageName, outputImageName, drawNum):
    draw = ImageDraw.Draw(img) #��ȡͼ����Ϣ
    myfont = ImageFont.truetype('C:/windows/fonts/Arial.ttf', size = 40) #��ȡ������Ϣ
    fillcolor = "#ff0000" #��ȡ��ɫ��Ϣ ff0000 �����ɫ
    width, height = img.size #��ȡͼ�񳤿�
    draw.text((width - 45, 5), drawNum, font = myfont, fill = fillcolor) #д��
    img.save(outputImageName, 'jpeg') #����ͼƬ

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