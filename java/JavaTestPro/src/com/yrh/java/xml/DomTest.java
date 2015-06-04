package com.yrh.java.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

	/**
	 * 利用 DOM 方法对 XML 文件进行解析和生成
	 */
	public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		DomTest test = new DomTest();
		test.createXML();
	}
	
	/**
	 * 生成 XML 文件
	 */
	public void createXML() throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		Document doc = getDocumentBuilder().newDocument();
		doc.setXmlStandalone(true);
		// 创建一个节点
		Element bookStore = doc.createElement("bookstore");
		// 创建一个子节点
		Element book = doc.createElement("book");
		// 设置属性
		book.setAttribute("id", "1");
		// 设置姓名子节点
		Element name = doc.createElement("name");
		name.setTextContent("傲慢与偏见");
		// 添加到 book 节点的自己点中
		book.appendChild(name);
		// 将 book 节点设置成 bookstore 节点的子节点
		bookStore.appendChild(book);
		// 将该节点添加到 Document 中去
		doc.appendChild(bookStore);
		
		// 将 Document 写入 XML 文件中
		// 1.获得一个 Transforemer 实例
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		// 2.设置格式，使其换行（可选项）
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		// 3.转换
		tf.transform(new DOMSource(doc), new StreamResult(new File("demo/books_output.xml")));
	}

	/**
	 * 对 XML 文件进行解析
	 */
	public void XMLParse() throws ParserConfigurationException,
			SAXException, IOException {
		// 通过 parse() 方法，对 XML 文件进行加载
		Document doc = getDocumentBuilder().parse("demo/books.xml");
		// 通过标签获得该元素的集合 nodelist
		NodeList nl = doc.getElementsByTagName("book");
		// 遍历 nodelist
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			System.out.println("------------第" + (i + 1) + "本书------------");
			// 获得该节点的属性集合
			NamedNodeMap nnm = node.getAttributes();
			System.out.println("一共有" + nnm.getLength() + "个属性");
			for (int j = 0; j < nnm.getLength(); j++) {
				System.out.println("属性名：" + nnm.item(j).getNodeName()
						+ "----属性值：" + nnm.item(j).getNodeValue());
			}

			// 获得该节点的子节点集合 nodelist
			NodeList childNodeList = node.getChildNodes();
			System.out.println("子属性名有" + childNodeList.getLength()
					+ "个");
			// 遍历
			for (int k = 0; k < childNodeList.getLength(); k++) {
				// 判断节点的属性
				if (childNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("\t子属性名："
							+ childNodeList.item(k).getNodeName()
							+ "----属性值："
							+ childNodeList.item(k).getTextContent());
				}
			}
			System.out.println("------------------------------\n");
		}
	}

	/**
	 * 创建 DocumentBuilder 实例
	 * @return DocumentBuilder 实例
	 */
	private DocumentBuilder getDocumentBuilder()
			throws ParserConfigurationException {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder();
	}

}
