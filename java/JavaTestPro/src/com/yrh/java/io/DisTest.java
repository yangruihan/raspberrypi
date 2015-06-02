package com.yrh.java.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisTest {

	/**
	 * ≤‚ ‘DataInputStream
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String file = "demo\\Dos.txt";
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		int i = dis.readInt();
		System.out.println(i);
		long j = dis.readLong();
		System.out.println(j);
		String s = dis.readUTF();
		System.out.println(s);
		char c = dis.readChar();
		System.out.print(c);
		c = dis.readChar();
		System.out.print(c);
	}

}
