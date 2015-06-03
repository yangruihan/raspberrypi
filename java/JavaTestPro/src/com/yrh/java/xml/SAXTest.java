package com.yrh.java.xml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SAXTest {
	
	/**
	 * ���ڲ��� SAX �����µ� xml �ļ�����
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// �½�һ�� SAXParserFactory ʵ��
		SAXParserFactory spf = SAXParserFactory.newInstance();
		// �½�һ�� SAXParser ʵ��
		SAXParser sp = spf.newSAXParser();
		// �½�һ���Զ���handler��
		MySAXParserHandler handler = new MySAXParserHandler();
		sp.parse("demo\\books.xml", handler);
	}
}
