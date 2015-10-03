'''
Created on 2014-2-20

@author: Vincent
'''

from html.parser import HTMLParser

class TieBaParser(HTMLParser):
    def __init__(self):
        HTMLParser.__init__(self)
        self.tieBaList = list()
        self.flag = False
        
    def getTieBaList(self):
        return self.tieBaList
    
    def handle_starttag(self, tag, attrs):
        if tag == "a":
            for name , value in attrs:
                if name == "href" and "m?kw=" in value:
                    self.flag = True
                        
    def handle_data(self, data):
        if self.flag:
            self.tieBaList.append(data)
            self.flag = False
            

