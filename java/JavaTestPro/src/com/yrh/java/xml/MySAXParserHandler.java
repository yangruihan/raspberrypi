package com.yrh.java.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 新建一个 SAXParserHandler 类，继承自DefaultHandler
 */
public class MySAXParserHandler extends DefaultHandler {

	int bookIndex = 0;

	/**
	 * 开始扫描标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")) {
			System.out.println("------------第" + ++bookIndex + "本书------------");
//			// 第一种方法，知道属性名
//			System.out.println(attributes.getValue("id"));
			// 第二种方法，不知道属性名，进行遍历
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println("属性名：" + attributes.getQName(i) + "属性值：" + attributes.getValue(i));
			}
		}
		if (!qName.equals("bookstore")) {
		System.out.print("子属性名：" + qName); 
		}
	}

	/**
	 * 结束扫描标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("book")) {
			System.out.println("------------------------------\n");
		}
	}
	
	/**
	 * 扫描节点中的内容
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch, start, length);
		if (!str.trim().equals("")) {
			System.out.println("----属性值：" + str);
		}
	}

	/**
	 * 开始扫描文件
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("扫描开始");
	}

	/**
	 * 结束扫描文件
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("结束扫描");
	}
}
