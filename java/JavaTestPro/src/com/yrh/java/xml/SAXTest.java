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

import org.xml.sax.SAXException;

public class SAXTest {
	
	/**
	 * 使用 SAX 方法解析和生成 XML 文件
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXTest test = new SAXTest();
	}
	
	/**
	 * 生成 XML 文件
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws TransformerFactoryConfigurationError 
	 * @throws TransformerConfigurationException 
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
