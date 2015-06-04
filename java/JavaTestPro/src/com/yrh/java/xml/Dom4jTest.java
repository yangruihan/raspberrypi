package com.yrh.java.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {

	public static void main(String[] args) throws DocumentException, IOException {
		Dom4jTest test = new Dom4jTest();
		test.createXML();
	}
	
	/**
	 * 生成 XML 文件
	 * @throws IOException 
	 */
	public void createXML() throws IOException {
		// 通过 DocumentHelper 的 createDocument() 方法创建一个 Document 实例
		Document doc = DocumentHelper.createDocument();
		// 添加根节点
		Element rss = doc.addElement("rss");
		// 添加一个版本属性
		rss.addAttribute("version", "2.0");
		
		// 添加子节点
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("IT新闻");
		
		// 设置 XML 格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		
		// 创建一个 XMLWriter 实例，用来向文件中写入 XML 内容
		XMLWriter writer = new XMLWriter(new FileOutputStream("demo/rssnews.xml"), format);
		// 设置生成 XML 时，是否转义，默认为 true
		writer.setEscapeText(false);
		// 将 Document 中的内容写入文件中
		writer.write(doc);
		// 关闭文件
		writer.close();
	}

	/**
	 * 解析 XML 文件
	 */
	public void parseXML() throws DocumentException {
		// 获取一个 SAXReader 实例
		SAXReader sr = new SAXReader();
		// 获取一个 Document 实例
		Document doc = sr.read(new File("demo/books.xml"));
		// 获取 根节点
		Element root = doc.getRootElement();
		// 获得根节点下的子节点的迭代器
		Iterator<Object> iter = root.elementIterator();
		// 遍历子节点
		while (iter.hasNext()) {
			System.out.println("================================");
			// 获得实体
			Element book = (Element) iter.next();
			// 获得实体的属性
			List<Attribute> attrs = book.attributes();
			// 遍历并输出属性
			for (Attribute attr : attrs) {
				System.out.println("节点属性名：" + attr.getName() + "----属性值："
						+ attr.getValue());
			}
			// 获得该实体的子节点的迭代器
			Iterator<Object> childIter = book.elementIterator();
			// 遍历该实体的子节点
			while (childIter.hasNext()) {
				Element childNode = (Element) childIter.next();
				// 获得实体的属性
				System.out.println("子节点属性名：" + childNode.getName() + "----属性值："
						+ childNode.getText());

			}

			System.out.println("================================");
		}
	}

}
