package com.yrh.java.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * �½�һ�� SAXParserHandler �࣬�̳���DefaultHandler
 */
public class MySAXParserHandler extends DefaultHandler {

	/**
	 * ��ʼɨ���ǩ
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
	}
	
	/**
	 * ����ɨ���ǩ
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
	}
	
	/**
	 * ��ʼɨ���ļ�
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("ɨ�迪ʼ");
	}
	
	/**
	 * ����ɨ���ļ�
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("����ɨ��");
	}
}
