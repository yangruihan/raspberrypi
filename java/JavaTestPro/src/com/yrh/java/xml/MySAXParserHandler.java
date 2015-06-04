package com.yrh.java.xml;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 自定义 SAXParserHandler 继承自 DefaultHandler
 */
public class MySAXParserHandler extends DefaultHandler {
	
	Book bookEntity = null;
	ArrayList<Book> bookEntities = new ArrayList<Book>();
	String tempAttr = null;
	
	int bookIndex = 0;

	/**
	 * 开始节点
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")) {
			System.out
					.println("------------第" + ++bookIndex + "本书------------");
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println("属性名：" + attributes.getQName(i) + "----属性值："
						+ attributes.getValue(i));
				bookEntity = new Book();
			}
		}
		if (!qName.equals("bookstore")) {
			System.out.print("子属性名：" + qName);
			tempAttr = qName;
		}
	}

	/**
	 * 结束节点
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals("book")) {
			System.out.println("------------------------------\n");
			if (bookEntity != null) {
				bookEntities.add(bookEntity);
				bookEntity = null;
			}
		}
	}

	/**
	 * 文字内容
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String str = new String(ch, start, length);
		if (!str.trim().equals("")) {
			System.out.println("----属性值：" + str);
			if (tempAttr.equals("name")) {
				bookEntity.setName(str);
			} else if (tempAttr.equals("author")) {
				bookEntity.setAuthor(str);
			} else if (tempAttr.equals("year")) {
				bookEntity.setYear(str);
			} else if (tempAttr.equals("price")) {
				bookEntity.setPrice(str);
			} else if (tempAttr.equals("language")) {
				bookEntity.setLanguage(str);
			}
		}
	}

	public ArrayList<Book> getBookEntities() {
		return bookEntities;
	}

	public void setBookEntities(ArrayList<Book> bookEntities) {
		this.bookEntities = bookEntities;
	}

	/**
	 * 开始 XML 扫描
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("开始扫描");
	}

	/**
	 * 结束 XML 扫描
	 */
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("结束扫描");
	}
}
