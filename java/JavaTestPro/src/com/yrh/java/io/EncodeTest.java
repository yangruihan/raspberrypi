package com.yrh.java.io;

import java.io.UnsupportedEncodingException;

public class EncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String s = "���abc";

		/*
		 * ���Ϊ��c4 e3 ba c3 61 62 63 �� �� a b c ���ۣ�GBK�к���һ��ռ2���ֽڣ���ĸһ��ռ1���ֽ�
		 */
		byte[] bytes = s.getBytes("GBK");
		for (byte b : bytes) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		System.out.println();

		/*
		 * ���Ϊ��e4 bd a0 e5 a5 bd 61 62 63 �� �� a b c
		 * ���ۣ�utf-8��ÿһ������ռ3���ֽڣ�ÿһ����ĸռһ���ֽ�
		 */
		byte[] bytes1 = s.getBytes("utf-8");
		for (byte b : bytes1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		System.out.println();

		/*
		 * ���Ϊ��4f 60 59 7d 0 61 0 62 0 63 �� �� a b c
		 * ���ۣ�utf-16be��java��String���õ�Ĭ�ϱ��뷽ʽ�������о�ռ2���ֽ�
		 */
		byte[] bytes2 = s.getBytes("utf-16be");
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

	}

}
