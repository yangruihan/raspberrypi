import tetris

class Main:
    def __init__(self, screen):
        self.screen = screen

    def run(self, elapse):
        return self.tetris.update(elapse)

    def start(self, kind):
        if kind == 6:
            self.tetris = tetris.Tetris(self.screen)
        else:
            self.tetris = eval(
                    "tetris.Tetris" + str(kind) + "(self.screen)")
