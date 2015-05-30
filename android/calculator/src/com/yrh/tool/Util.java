package com.yrh.tool;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 工具类
 * 
 * @author Yrh
 *
 */
public class Util {

	/**
	 * 把一个ArrayList<String> 返回格式化数字，每三位加一个逗号
	 * 
	 * @param input
	 * @return
	 */
	public static String getFormatNumber(ArrayList<String> input) {
		String result = "";
		Iterator<String> iter = input.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			// 如果不是操作符的话
			if (!lastIsOpt(temp)) {
				result += getFormatNumber(temp);
			} else {
				result += temp;
			}
		}
		return result;
	}

	/**
	 * 返回格式化数字，每三位加一个逗号
	 * 
	 * @param str
	 * @return 形似 X,XXX,XXX.XXXXX 的字符串
	 */
	public static String getFormatNumber(String input) {
		boolean isNe = false; // 判断是否为负数
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
	 * 判断字符串最后一位是否是运算符
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
	 * 判断字符串最后一位是否是小数点
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
		String IFX = ""; // 中缀表达式
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
