package com.yrh.o2;

public class o2 {

	public static String zipString(String iniString) {
		// write code here

		StringBuffer resString = new StringBuffer();

		int i = 0;

		while (i < iniString.length()) {
			int num = 1;
			while (i + num < iniString.length() && iniString.charAt(i) == iniString.charAt(i + num)) {
				num++;
			}

			resString.append(iniString.charAt(i));
			resString.append(num + "");

			i = i + num;
		}

		String s = resString.toString();

		if (s.length() >= iniString.length()) {
			return iniString;
		} else {
			return s;
		}
	}

	public static void main(String[] args) {
		System.out.println(zipString("welcometonowcoderrrrr"));
	}
}
