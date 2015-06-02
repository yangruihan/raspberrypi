package com.yrh.java.io;

import java.io.FileInputStream;
import java.io.IOException;

public class IOUtils {

	public static void printHex(String filename) throws IOException {
		FileInputStream fi = new FileInputStream(filename);
		int i = 1;
		int b = 0;
		while ((b = fi.read()) != -1) {
			if (b < 0xf) {
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + "  ");
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
	}
}
