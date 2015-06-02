package com.yrh.java.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException{
		
		File file = new File("demo");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		File file2 = new File("demo", "test.txt");
		if (!file2.exists()) {
			file2.createNewFile();
		}
		
		RandomAccessFile raf = new RandomAccessFile(file2, "rw");
		
		int a = 5;
		raf.writeInt(a);
		System.out.println(raf.getFilePointer());
		
		String str = "ÖÐ¹ú";
		byte[] bytes = str.getBytes("utf-8");
		raf.write(bytes);
		System.out.println(raf.getFilePointer());
		
		raf.seek(0);
		byte[] bytes1 = new byte[(int) raf.length()];
		raf.read(bytes1);
		System.out.println(Arrays.toString(bytes1));
	}
}
