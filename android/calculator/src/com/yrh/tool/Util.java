package com.yrh.tool;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ������
 * 
 * @author Yrh
 *
 */
public class Util {

	/**
	 * ��һ��ArrayList<String> ���ظ�ʽ�����֣�ÿ��λ��һ������
	 * 
	 * @param input
	 * @return
	 */
	public static String getFormatNumber(ArrayList<String> input) {
		String result = "";
		Iterator<String> iter = input.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			// ������ǲ������Ļ�
			if (!lastIsOpt(temp)) {
				result += getFormatNumber(temp);
			} else {
				result += temp;
			}
		}
		return result;
	}

	/**
	 * ���ظ�ʽ�����֣�ÿ��λ��һ������
	 * 
	 * @param str
	 * @return ���� X,XXX,XXX.XXXXX ���ַ���
	 */
	public static String getFormatNumber(String input) {
		boolean isNe = false; // �ж��Ƿ�Ϊ����
		if (input.startsWith("(-")) {
			input = input.substring(input.indexOf("-") + 1, input.indexOf(")"));
			isNe = true;
		}
		String str = "";
		String str1 = "";
		if (input.contains(".")) {
			str = input.substring(0, input.indexOf("."));
			if (!input.endsWith(".")) {
				str1 = input.substring(input.indexOf("."), input.length());
			} else {
				str1 = ".";
			}
		} else {
			str = input;
		}

		if (str.length() <= 3) {
			if (isNe) {
				return "(-" + str + str1 + ")";
			}
			return str + str1;
		}

		String str2 = "";
		int size = 0;
		if (str.length() / 3 > 0) {
			size = str.length() % 3;
			str2 += str.substring(0, size);
		}
		int i = size;
		while (i < str.length()) {
			if (i != 0) {
				str2 += "," + str.substring(i, i + 3);
			} else {
				str2 += str.substring(i, i + 3);
			}
			i += 3;
		}

		if (isNe) {
			return "(-" + str2 + str1 + ")";
		}
		return str2 + str1;
	}

	/**
	 * �ж��ַ������һλ�Ƿ��������
	 * 
	 * @param str
	 * @return
	 */
	public static boolean lastIsOpt(String str) {
		String[] opt = { "+", "-", "*", "/" };
		for (int i = 0; i < opt.length; i++) {
			if (str.endsWith(opt[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �ж��ַ������һλ�Ƿ���С����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean lastIsPoint(String str) {
		if (str.endsWith(".")) {
			return true;
		}
		return false;
	}

	public static String calculate(ArrayList<String> input) {
		String IFX = ""; // ��׺���ʽ
		Iterator<String> iter = input.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			if (temp.startsWith("(-")) {
				temp = temp.substring(0, temp.indexOf("-")) + "0"
						+ temp.substring(temp.indexOf("-"), temp.length());
			}
			IFX += temp;
		}
		System.out.println(IFX);
		return CaculateFunction.Evaluate(IFX + "=");
	}
}
