package com.yrh.java.xml;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		// 生成一个 DocumentBuilderFactory 实例
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 生成一个 DocumentBuilder 实例
		DocumentBuilder db = dbf.newDocumentBuilder();
		// 通过 parse 方法进行加载
		Document doc = db.parse("demo\\books.xml");
		// 通过一个元素的标记名，获得 nodelist
		NodeList nl = doc.getElementsByTagName("book");
		// 遍历 nodelist
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			System.out.println("------------第" + (i + 1) + "本书------------");
			// 获取node里所有的属性
			NamedNodeMap nnm = node.getAttributes();
			System.out.println("该节点一共有" + nnm.getLength() + "个属性");
			for (int j = 0; j < nnm.getLength(); j++) {
				System.out.println("属性名：" + nnm.item(j).getNodeName()
						+ "----属性值：" + nnm.item(j).getNodeValue());
			}
			
			// 如果知道该节点的属性，也可以通过下面这种方法获取属性值
			// Element el = (Element) nl.item(i);
			// System.out.println("属性名：id----属性值：" + el.getAttribute("id"));

			// 获得子节点nodelist
			NodeList childNodeList = node.getChildNodes();
			System.out.println("该节点一共有" + childNodeList.getLength() + "个子属性");
			// 遍历子节点
			for (int k = 0; k < childNodeList.getLength(); k++) {
				// 因为 空格或换行符 会被默认读取为 #test 类型的节点，因此这里要过滤一下
				if (childNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
//					System.out.println("\t子属性名："
//							+ childNodeList.item(k).getNodeName()
//							+ "----属性值："
//							+ childNodeList.item(k).getFirstChild()
//									.getNodeValue());
					System.out.println("\t子属性名："
							+ childNodeList.item(k).getNodeName()
							+ "----属性值："
							+ childNodeList.item(k).getTextContent());
				}
			}
			System.out.println("------------------------------\n");
		}
	}

}
