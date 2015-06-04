package com.yrh.java.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class SAXTest {
	
	/**
	 * 使用 SAX 方法解析和生成 XML 文件
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerFactoryConfigurationError {
		SAXTest test = new SAXTest();
		test.createXML();
	}
	
	/**
	 * 生成 XML 文件
	 */
	public void createXML() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerFactoryConfigurationError {
		ArrayList<Book> list = parseXML();
		// 创建一个 TransformerHandler 对象
		TransformerHandler tfhandler = ((SAXTransformerFactory) SAXTransformerFactory.newInstance()).newTransformerHandler();
		// 通过 TransformerHandler 创建一个 Transformer 对象
		Transformer tf = tfhandler.getTransformer();
		// 通过 Transformer 实例对即将生成的 XML 文件进行设置
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		// 创建一个 Result 实例
		Result res = new StreamResult(new FileOutputStream(new File("demo/books_output2.xml")));
		// 将 Result 实例和 Transformer 实例 绑定起来
		tfhandler.setResult(res);
		// 添加节点
		// 开始 Document
		tfhandler.startDocument();
		AttributesImpl attrs = new AttributesImpl();
		tfhandler.startElement("", "", "bookstore", attrs);
		attrs.clear();
		
		for (Book book : list) {
			// 创建书本 id
			attrs.addAttribute("", "", "id", "", book.getId() + "");
			tfhandler.startElement("", "", "book", attrs);
			attrs.clear();
			
			// 创建子节点
			createChildElement(tfhandler, attrs, book);
			
			tfhandler.endElement("", "", "book");
		}
		
		
		tfhandler.endElement("", "", "bookstore");
		// 结束 Document
		tfhandler.endDocument();
	}

	private void createChildElement(TransformerHandler tfhandler,
			AttributesImpl attrs, Book book) throws SAXException {
		// 创建书名节点
		tfhandler.startElement("", "", "name", attrs);
		tfhandler.characters(book.getName().toCharArray(), 0, book.getName().length());
		tfhandler.endElement("", "", "name");
		attrs.clear();
		
		// 创建时间节点
		tfhandler.startElement("", "", "year", attrs);
		tfhandler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
		tfhandler.endElement("", "", "year");
		attrs.clear();
		
		// 创建价格节点
		tfhandler.startElement("", "", "price", attrs);
		tfhandler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
		tfhandler.endElement("", "", "price");
		attrs.clear();
		
		// 创建语言节点
		if (book.getLanguage() != null) {
			tfhandler.startElement("", "", "language", attrs);
			tfhandler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
			tfhandler.endElement("", "", "language");
			attrs.clear();	
		}
		
		// 创建作者节点
		if (book.getAuthor() != null) {
			tfhandler.startElement("", "", "author", attrs);
			tfhandler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
			tfhandler.endElement("", "", "author");
			attrs.clear();	
		}
	}
	
	/**
	 * 解析 XML 文件
	 * @return
	 */
	public ArrayList<Book> parseXML() throws ParserConfigurationException,
			SAXException, IOException {
		// 获得一个 SAXParserFactory 实例
		SAXParserFactory spf = SAXParserFactory.newInstance();
		// 获得 SAXParser 实例
		SAXParser sp = spf.newSAXParser();
		// 创建一个自己定义的 handler 文件
		MySAXParserHandler handler = new MySAXParserHandler();
		sp.parse("demo/books.xml", handler);
		return handler.getBookEntities();
	}
}
