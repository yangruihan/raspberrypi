package com.yrh.java.io;

import java.io.File;

public class FileTest {

	/*
	 * java.io.File�����ڱ�ʾ�ļ���Ŀ¼�� File��ֻ�����ڱ�ʾ�ļ���Ŀ¼������Ϣ�����ƣ���С�ȣ������������ļ����ݵķ���
	 */

	public static void main(String[] args) {
		File file = new File("/Users/yangruihan/WorkSpace/Java_ws");
		System.out.println(file.exists());
		System.out.println(file.toPath());
		System.out.println(file.toURI());
		System.out.println(file.toString());
		System.out.println(file);
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
	}

}
