import pygame
from pygame.locals import *
from menu import Menu
from main import Main
import sound, util

class Game:
    def __init__(self):
        # current stat of game
        self.stat = 'menu'
        # init pygame
        pygame.mixer.pre_init(44100, 16, 2, 1024*4)
        pygame.init()
        pygame.display.set_caption("FUNNY TETRIS")
        self.init()
        try:
            self.screen = pygame.display.set_mode((640, 480), 
                    HWSURFACE | SRCALPHA, 32)
        except:
            self.screen = pygame.display.set_mode((640, 480), 
                    SRCALPHA, 32)
        try:
            pygame.display.set_icon(pygame.image.load(
                util.file_path("icon.png")).convert_alpha())
        except:
            # some platfom do not allow change icon after shown
            pass
        # init sub modules
        self.menu = Menu(self.screen)   # menu show start menu
        self.main = Main(self.screen)   # main is the real tetris

    def init(self):
        util.init()
        sound.load()

    def loop(self):
        clock = pygame.time.Clock()
        while self.stat != 'quit':
            elapse = clock.tick(25)
            if self.stat == 'menu':
                self.stat = self.menu.run(elapse)
            elif self.stat == 'game':
                self.stat = self.main.run(elapse)

            if self.stat.startswith('level'):
                level = int(self.stat.split()[1])
                print "Start game at level", level
                self.main.start(level)
                self.stat = "game"

            pygame.display.update()
        pygame.quit()

def run():
    tetris = Game()
    tetris.loop()

if __name__ == '__main__':
    print "Please run me with 'run_game.py'!"
