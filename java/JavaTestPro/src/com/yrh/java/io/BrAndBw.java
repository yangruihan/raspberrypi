package com.yrh.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BrAndBw {

	/**
	 * BufferReader ∫Õ BufferWriter/PrintWriter ≤‚ ‘
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File("demo\\test.txt")), "utf-8"));
		PrintWriter pw = new PrintWriter(new File("demo\\test2.txt"));

		String s;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
			pw.println(s);
			pw.flush();
		}
		br.close();
		pw.close();
	}

}
