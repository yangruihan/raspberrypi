#!/usr/bin/python
#-*- coding:utf-8 -*-

import re  
import urllib  
import urllib2  
import cookielib  
import os  
import json  
import sys  
import time  
from urllib import quote,unquote  
from urllib2 import HTTPError  
from urllib2 import URLError  

#登陆模块  
def Login():  
try :  
    cj = cookielib.CookieJar();  
    opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj));  
    urllib2.install_opener(opener);   
      
    #打开获得 cookie  
    #info_URL = "http://portal.uestc.edu.cn/index.portal"  
	info_URL = "http://202.114.242.231:8036/default.html"
    #info_Login_URL = "https://uis.uestc.edu.cn/amserver/UI/Login";       
    info_Login_URL = "http://jwxt.wust.edu.cn/whkjdx/"
    
    infoOPEN = urllib2.urlopen(info_URL)  
    print 1  
    #生成要发送的数据  
    LoginData = {  
        'IDToken0':'',  
        'IDToken1':'20142106XXXX',  
        'IDToken2':'xxxxxx',  
        'IDButton':'Submit',  
        'goto':'aHR0cDovL3BvcnRhbC51ZXN0Yy5lZHUuY24vbG9naW4ucG9ydGFs',  
        'encoded':'true',  
        'gx_charset':'UTF-8',  
        };   
      
    print 2  
          
    #把发送数据转换格式  
    LoginData = urllib.urlencode(LoginData);      
      
    #生成请求数据  
    info_Login_Request = urllib2.Request(info_Login_URL, LoginData);  
      
    #添加数据头部  
    info_Login_Request.add_header('Content-Type', "application/x-www-form-urlencoded");  
    info_Login_Request.add_header('User-Agent', "Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");  
    print 3  
    #发送请求，尝试登陆  
    info_Login_Open = urllib2.urlopen(info_Login_Request);  
    print 4  
    #验证登陆是否成功  
    tt = urllib2.urlopen(info_URL).read()  
    fout=open("tt.html","w")  
    fout.write(tt)  
    print 'success!'  
except :  
    print "登陆出错啦！"  

if __name__ == "__main__" :  
	Login()  
