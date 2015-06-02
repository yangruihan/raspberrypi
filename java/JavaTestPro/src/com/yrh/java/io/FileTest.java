package com.yrh.java.io;

import java.io.File;

public class FileTest {

	/*
	 * java.io.File类用于表示文件（目录） File类只能用于表示文件（目录）的信息（名称，大小等），不能用于文件内容的访问
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
