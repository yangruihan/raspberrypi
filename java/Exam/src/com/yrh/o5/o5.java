package com.yrh.o5;

public class o5 {

	public static boolean checkSam(String stringA, String stringB) {
        // write code here
		
		String[] s = stringA.trim().split(" ");
		
		
		for (int i = 0; i < s.length; i ++) {
			if (!stringB.contentEquals(s[i])) {
				return false;
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		
	}
}
