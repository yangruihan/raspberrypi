package com.yrh.java.xml;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SAXTest {
	
	/**
	 * 用于测试 SAX 方法下的 xml 文件解析
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// 新建一个 SAXParserFactory 实例
		SAXParserFactory spf = SAXParserFactory.newInstance();
		// 新建一个 SAXParser 实例
		SAXParser sp = spf.newSAXParser();
		// 新建一个自定义handler类
		MySAXParserHandler handler = new MySAXParserHandler();
		sp.parse("demo\\books.xml", handler);
	}
}
