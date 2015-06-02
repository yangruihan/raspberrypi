package com.yrh.java.io;

import java.io.File;
import java.io.IOException;

public class CopyFileTest {

	/**
	 * 用来测试复制文件的速度
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		long start = System.currentTimeMillis();
		IOUtils.copyFile(new File("demo\\1.mp3"), new File("demo\\2.mp3"));
		long end = System.currentTimeMillis();
		System.out.println("copy file by byte[] ----> use time: " + (end - start));
		start = System.currentTimeMillis();
		IOUtils.copyFileByBuffer(new File("demo\\1.mp3"), new File("demo\\3.mp3"));
		end = System.currentTimeMillis();
		System.out.println("copy file by buffer ----> use time: " + (end - start));
		start = System.currentTimeMillis();
		IOUtils.copyFileByByte(new File("demo\\1.mp3"), new File("demo\\4.mp3"));
		end = System.currentTimeMillis();
		System.out.println("copy file by byte ----> use time: " + (end - start));
		
	}

}
