package com.yrh.java.io;

import java.io.File;
import java.io.IOException;

public class IOUtilsTest2 {

	public static void main(String[] args) {
		try {
			IOUtils.copyFile(new File("demo" + File.separator + "test.txt"),
					new File("demo" + File.separator + "test_copy.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
