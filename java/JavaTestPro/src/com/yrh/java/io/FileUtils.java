package com.yrh.java.io;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 * 
 * @author yangruihan
 *
 */
public class FileUtils {
	
	public static void listDirectory(File dir) throws IOException {
		printFileName(dir, 0);
		listDirectory(dir, 1);
	}

	private static void listDirectory(File dir, int level) throws IOException {
		// 如果目录or文件不存在
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录 " + dir + " 不存在！");
		}
		
		File[] files = dir.listFiles();

		for (File file : files) {
			// 忽略隐藏文件
			if (file.getName().startsWith(".")) {
				continue;
			}
			
			// 如果是文件的话
			if (file.isFile()) {
				// 打印文件名字
				printFileName(file, level);
			}
			// 如果是目录的话
			if (file.isDirectory()) {
				// 打印目录名字
				printFileName(file, level);
				listDirectory(file, level + 1);
			}
		}// end of for
	}

	private static void printFileName(File dir, int level) {
		if (dir.isFile()) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("  ");
			}
			System.out.println("┠ " + dir.getName());
		}
		if (dir.isDirectory()) {
			for (int i = 0; i < level; i++) {
				System.out.print("  ");
			}
			System.out.println("╂ " + dir.getName());
		}
	}
}
