package com.yrh.java.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {

	public static void main(String[] args) throws DocumentException {
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
