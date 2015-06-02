package com.yrh.java.io;

import java.io.IOException;

public class IOUtilsTest {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		IOUtils.printHex("src\\com\\yrh\\java\\io\\info.txt");
		long end =  System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start); // 用时 21 ms
		
		start = System.currentTimeMillis();
		IOUtils.printHexByByte("src\\com\\yrh\\java\\io\\info.txt");
		end = System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start); // 用时 7 ms 当文件过大时，使用下面这种批量读取方式速度可能是上面那种方式的很多倍
	}

}
