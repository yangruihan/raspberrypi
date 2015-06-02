package com.yrh.java.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosTest {

	/**
	 * ���� DataOuputStream
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String file = "demo\\Dos.txt";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(100);
		dos.writeLong(21239123l);
		dos.writeUTF("�й�");
		dos.writeChars("�й�");
		dos.close();
		IOUtils.printHex(file);
	}

}
