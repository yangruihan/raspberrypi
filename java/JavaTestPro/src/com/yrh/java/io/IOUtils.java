package com.yrh.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtils {

	/**
	 * 单字节读取
	 * 
	 * @param filename
	 * @throws IOException
	 *             ！单字节读取不适合大文件！效率低
	 */
	public static void printHex(String filename) throws IOException {
		FileInputStream fi = new FileInputStream(filename);
		int i = 1;
		int b = 0;
		while ((b = fi.read()) != -1) {
			if (b < 0xf) {
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
			if (i++ % 10 == 0) {
				System.out.println();
			}
		}
		fi.close();
	}

	/**
	 * 批量读取
	 * 
	 * @param filename
	 * @throws IOException
	 *             适合大文件，效率高
	 */
	public static void printHexByByte(String filename) throws IOException {
		FileInputStream fi = new FileInputStream(filename);
		byte[] bytes = new byte[10 * 1024]; // 10k 的缓冲区
		int j = 1;
		int b = 0;
		while (((b = fi.read(bytes, 0, bytes.length)) != -1)) {
			for (int i = 0; i < b; i++) {
				if (bytes[i] <= 0xf) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(bytes[i] & 0xff) + " ");
				if (j++ % 10 == 0) {
					System.out.println();
				}
			}
		}
		fi.close();
	}

	/**
	 * 复制文件，byte[] 数组批量拷贝文件
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		// 如果文件不存在
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件 \"" + srcFile + "\" 不存在！");
		}
		// 如果文件不是文件类型
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是一个文件！");
		}

		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);

		byte[] bytes = new byte[10 * 1024];
		int b = 0;
		while ((b = in.read(bytes, 0, bytes.length)) != -1) {
			out.write(bytes, 0, b);
		}
		in.close();
		out.close();
	}

	/**
	 * 复制文件，buffer 缓冲区复制文件
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile)
			throws IOException {
		// 如果文件不存在
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件 \"" + srcFile + "\" 不存在！");
		}
		// 如果文件不是文件类型
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是一个文件！");
		}

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));
		int b = 0;
		while ((b = bis.read()) != -1) {
			bos.write(b);
		}
		bos.flush();
		bis.close();
		bos.close();
	}

	public static void copyFileByByte(File srcFile, File destFile)
			throws IOException {
		// 如果文件不存在
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件 \"" + srcFile + "\" 不存在！");
		}
		// 如果文件不是文件类型
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是一个文件！");
		}

		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);

		int b = 0;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
		in.close();
		out.close();
	}
}
