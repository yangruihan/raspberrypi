package com.yrh.java.io;

import java.io.IOException;

public class IOUtilsTest {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		IOUtils.printHex("src\\com\\yrh\\java\\io\\info.txt");
		long end =  System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start); // ��ʱ 21 ms
		
		start = System.currentTimeMillis();
		IOUtils.printHexByByte("src\\com\\yrh\\java\\io\\info.txt");
		end = System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start); // ��ʱ 7 ms ���ļ�����ʱ��ʹ����������������ȡ��ʽ�ٶȿ������������ַ�ʽ�ĺܶ౶
	}

}
