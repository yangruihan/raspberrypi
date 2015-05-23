import os, sys
import pygame

if hasattr(sys, 'frozen'):
    _ME_PATH = os.path.abspath(os.path.dirname(sys.executable))
    DATA_PATH = os.path.normpath(os.path.join(_ME_PATH, 'data'))
else:
    _ME_PATH = os.path.abspath(os.path.dirname(__file__))
    DATA_PATH = os.path.normpath(os.path.join(_ME_PATH, '..', 'data'))
_FONTS = {}

def file_path(filename=None):
    """ give a file(img, sound, font...) name, return full path name. """
    if filename is None:
        raise ValueError, 'must supply a filename'

    fileext = os.path.splitext(filename)[1]
    if fileext in ('.png', '.bmp', '.tga', '.jpg'):
        sub = 'image'
    elif fileext in ('.ogg', '.mp3', '.wav'):
        sub = 'sound'
    elif fileext in ('.ttf',):
        sub = 'font'

    file_path = os.path.join(DATA_PATH, sub, filename)
    print 'Will read', file_path

    if os.path.abspath(file_path):
        return file_path
    else:
        raise ValueError, "Cant open file `%s'." % file_path

def myprint(screen, string, pos, size='s', color=(255, 255, 255)):
    """ Print text to game display
        screen: display screen
        string: the text want to display
        pos:    the position of text
        size:   size of text(can be l, m, s)
        color:  the color of text
    """
    fs = _FONTS[size].render(str(string), True, color)
    screen.blit(fs, pos)

def init():
    """ init some pygame objects, such as font """
    print "DATA PATH is: ", DATA_PATH
    global _FONTS
    _FONTS['l'] = pygame.font.Font(file_path('default.ttf'), 48)
    _FONTS['m'] = pygame.font.Font(file_path('default.ttf'), 36)
    _FONTS['s'] = pygame.font.Font(file_path('default.ttf'), 24)

