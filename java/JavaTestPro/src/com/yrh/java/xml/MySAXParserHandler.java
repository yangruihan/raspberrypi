package com.yrh.java.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 新建一个 SAXParserHandler 类，继承自DefaultHandler
 */
public class MySAXParserHandler extends DefaultHandler {

	/**
	 * 开始扫描标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
	}
	
	/**
	 * 结束扫描标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
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
