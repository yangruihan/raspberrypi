package com.yrh.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtils {

	/**
	 * ���ֽڶ�ȡ
	 * 
	 * @param filename
	 * @throws IOException
	 *             �����ֽڶ�ȡ���ʺϴ��ļ���Ч�ʵ�
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
	 * ������ȡ
	 * 
	 * @param filename
	 * @throws IOException
	 *             �ʺϴ��ļ���Ч�ʸ�
	 */
	public static void printHexByByte(String filename) throws IOException {
		FileInputStream fi = new FileInputStream(filename);
		byte[] bytes = new byte[10 * 1024]; // 10k �Ļ�����
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
	 * �����ļ���byte[] �������������ļ�
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		// ����ļ�������
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ� \"" + srcFile + "\" �����ڣ�");
		}
		// ����ļ������ļ�����
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "����һ���ļ���");
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
	 * �����ļ���buffer �����������ļ�
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void copyFileByBuffer(File srcFile, File destFile)
			throws IOException {
		// ����ļ�������
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ� \"" + srcFile + "\" �����ڣ�");
		}
		// ����ļ������ļ�����
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "����һ���ļ���");
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
		// ����ļ�������
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ� \"" + srcFile + "\" �����ڣ�");
		}
		// ����ļ������ļ�����
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "����һ���ļ���");
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
