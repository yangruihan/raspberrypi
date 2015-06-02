package com.yrh.java.io;

import java.io.UnsupportedEncodingException;

public class EncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String s = "你好abc";

		/*
		 * 结果为：c4 e3 ba c3 61 62 63 你 好 a b c 结论：GBK中汉字一个占2个字节，字母一个占1个字节
		 */
		byte[] bytes = s.getBytes("GBK");
		for (byte b : bytes) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		System.out.println();

		/*
		 * 结果为：e4 bd a0 e5 a5 bd 61 62 63 你 好 a b c
		 * 结论：utf-8中每一个汉字占3个字节，每一个字母占一个字节
		 */
		byte[] bytes1 = s.getBytes("utf-8");
		for (byte b : bytes1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		System.out.println();

		/*
		 * 结果为：4f 60 59 7d 0 61 0 62 0 63 你 好 a b c
		 * 结论：utf-16be（java中String采用的默认编码方式），所有均占2个字节
		 */
		byte[] bytes2 = s.getBytes("utf-16be");
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

	}

}
