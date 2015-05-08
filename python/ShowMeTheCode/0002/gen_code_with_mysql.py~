#!/usr/bin/env python3
#-*- coding:utf-8 -*-

import mysql.connector
import os

def store_mysql(filename):
	conn = mysql.connector.connect(user = 'root', password = 'root', database = 'showmethecode')
	cursor = conn.cursor()
	
	#≈–∂œ±Ì «∑Ò¥Ê‘⁄
	cursor.execute("show tables in showmethecode;")
	tables = cursor.fetchall()
	findtables = False

	for table in tables:
		if 'code' in table:
			findtables = True

	if not findtables:
		cursor.execute('''
			CREATE TABLE showmethecode.code (
			id INT NOT NULL AUTO_INCREMENT,
			code VARCHAR(100) NOT NULL,
			PRIMARY KEY (id));
		''')

	with open(filename, 'rb') as f:
		for line in f.readlines():
			code = line.strip()
			cursor.execute('insert into showmethecode.code (code) values(%s);', [code])

	conn.commit()
	cursor.close()
	conn.close()

if __name__ == '__main__':
	filename = raw_input("Input file name: ")

	while not os.path.exists(filename):
		filename = raw_input("Input RIGHT file name: ")

	store_mysql(filename)
