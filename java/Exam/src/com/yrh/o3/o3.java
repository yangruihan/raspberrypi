package com.yrh.o3;

public class o3 {

	public static boolean checkDifferent(String iniString) {
        // write code here
		
		String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0; i < s.length(); i++){
			if (iniString.indexOf(s.charAt(i), iniString.indexOf(s.charAt(i))+1) != -1) {
				return false;
			}
		}
		
		return true;
    }
	
	public static void main(String[] args) {
	
		System.out.println(checkDifferent("aeiou"));
	}
}
