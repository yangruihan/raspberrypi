package com.yrh.o1;

public class o1 {

	public static String replaceSpace(String iniString, int length) {
        // write code here
		
		String resString;
		resString = iniString.replaceAll(" ", "%20");
		
		return resString;
    }
	
	public static void main(String[] args) {
		System.out.println(replaceSpace("Mr John Smith", 13));
	}
}
