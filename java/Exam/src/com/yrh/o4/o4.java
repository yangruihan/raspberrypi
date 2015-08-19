package com.yrh.o4;

public class o4 {
	public static String reverseString(String iniString) {
		// write code here
		
		StringBuffer s = new StringBuffer();
		for (int i = iniString.length() - 1; i >= 0; i--) {
			s.append(iniString.charAt(i));
		}
		
		return s.toString();
	}

	public static void main(String[] args) {

		System.out.println(reverseString("This is nowcoder"));
	}
}
