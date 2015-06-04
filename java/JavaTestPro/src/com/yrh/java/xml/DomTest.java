package com.yrh.java.xml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

	/**
	 * ���ڲ��� dom �����µ� xml �ļ�����
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		// ����һ�� DocumentBuilderFactory ʵ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// ����һ�� DocumentBuilder ʵ��
		DocumentBuilder db = dbf.newDocumentBuilder();
		// ͨ�� parse �������м���
		Document doc = db.parse("demo/books.xml");
		// ͨ��һ��Ԫ�صı��������� nodelist
		NodeList nl = doc.getElementsByTagName("book");
		// ���� nodelist
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			System.out.println("------------��" + (i + 1) + "����------------");
			// ��ȡnode�����е�����
			NamedNodeMap nnm = node.getAttributes();
			System.out.println("�ýڵ�һ����" + nnm.getLength() + "������");
			for (int j = 0; j < nnm.getLength(); j++) {
				System.out.println("��������" + nnm.item(j).getNodeName()
						+ "----����ֵ��" + nnm.item(j).getNodeValue());
			}

			// ���֪���ýڵ�����ԣ�Ҳ����ͨ���������ַ�����ȡ����ֵ
			// Element el = (Element) nl.item(i);
			// System.out.println("��������id----����ֵ��" +
			// el.getAttribute("id"));

			// ����ӽڵ�nodelist
			NodeList childNodeList = node.getChildNodes();
			System.out.println("�ýڵ�һ����" + childNodeList.getLength()
					+ "��������");
			// �����ӽڵ�
			for (int k = 0; k < childNodeList.getLength(); k++) {
				// ��Ϊ �ո���з� �ᱻĬ�϶�ȡΪ #test ���͵Ľڵ㣬�������Ҫ����һ��
				if (childNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
					// System.out.println("\t����������"
					// + childNodeList.item(k).getNodeName()
					// + "----����ֵ��"
					// + childNodeList.item(k).getFirstChild()
					// .getNodeValue());
					System.out.println("\t����������"
							+ childNodeList.item(k).getNodeName()
							+ "----����ֵ��"
							+ childNodeList.item(k).getTextContent());
				}
			}
			System.out.println("------------------------------\n");
		}
	}

}
