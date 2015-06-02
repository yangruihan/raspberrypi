package com.yrh.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {
	
	public static void main(String[] args) throws Exception {
		String file = "demo\\student.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(new Student("1001", "уехЩ", 22));
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu = (Student) ois.readObject();
		System.out.println(stu);
		oos.close();
		ois.close();
	}

}
