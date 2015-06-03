package com.yrh.java.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * �½�һ�� SAXParserHandler �࣬�̳���DefaultHandler
 */
public class MySAXParserHandler extends DefaultHandler {

	int bookIndex = 0;

	/**
	 * ��ʼɨ���ǩ
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")) {
			System.out.println("------------��" + ++bookIndex + "����------------");
//			// ��һ�ַ�����֪��������
//			System.out.println(attributes.getValue("id"));
			// �ڶ��ַ�������֪�������������б���
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println("��������" + attributes.getQName(i) + "����ֵ��" + attributes.getValue(i));
			}
		}
		if (!qName.equals("bookstore")) {
		System.out.print("����������" + qName); 
		}
	}

	/**
	 * ����ɨ���ǩ
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
	 * ɨ��ڵ��е�����
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch, start, length);
		if (!str.trim().equals("")) {
			System.out.println("----����ֵ��" + str);
		}
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
