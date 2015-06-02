package com.yrh.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IsrAndOswTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("demo\\test.txt"), "utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("demo\\test_output.txt"), "utf-8");
		char[] chars = new char[10 * 1024];
		int b = 0;
		while ((b = isr.read(chars, 0, chars.length)) != -1) {
			String s = new String(chars);
			osw.write(s);
			System.out.println(s);
			osw.flush();
		}
		isr.close();
		osw.close();
	}

}
