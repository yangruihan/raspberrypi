# -*- coding:utf-8 -*-

from PIL import ImageFont, Image, ImageDraw
import random
import string

class YZMInfo:

    def __init__(self, img, code):
        self.img = img
        self.code = code

def ygm(font_size = 20, count_min = 4, count_max = 10,code_height = 30,
        string = string.letters + string.digits, 
        font_color = ['black', 'darkblue', 'darkred', 'darkgreen'],
        font_family = 'arial.ttf'):
    if count_max < count_min:
        count_max = count_min
    code_count = random.randrange(count_min, count_max)
    background = (random.randrange(230, 255),
                  random.randrange(230, 255),
                  random.randrange(230, 255))
    line_color = [(random.randrange(0, 255),
                   random.randrange(0, 255),
                   random.randrange(0, 255)),
                  (random.randrange(0, 255),
                   random.randrange(0, 255),
                   random.randrange(0, 255)),
                  (random.randrange(0, 255),
                   random.randrange(0, 255),
                   random.randrange(0, 255))]

    img_width = (font_size + 5) * code_count
    img_height = code_height + font_size + 15
    verify = ''
    im = Image.new('RGB', (img_width, img_height), background)
    draw = ImageDraw.Draw(im)
    code = random.sample(string, code_count)
    draw = ImageDraw.Draw(im)
    for i in range(random.randrange(code_count / 2, code_count)):
        xy = (random.randrange(0, img_width), random.randrange(0, img_height),
              random.randrange(0, img_width), random.randrange(0, img_height))
        draw.line(xy, fill = random.choice(line_color), width = 1)

    x = font_size / 3
    for i in code:
        y = random.randrange(0, code_height)
        font = ImageFont.truetype(
            font_family, font_size + random.randrange(-font_size / 3, font_size))
        draw.text((x, y), i, font = font, fill = random.choice(font_color))
        x += font_size
        verify += i

    return YZMInfo(img = im, code = verify.upper())
        
if __name__ == '__main__':
	for i in range(100):
		info = ygm(font_size = 16,
				   code_height = 10,
				   string = string.letters + string.digits)
		info.img.save('test' + str(i) + '.gif')
		print info.code









