package com.yrh.java.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.EscapeStrategy;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOMTest {
	
	static Book bookEntity = null;
	static ArrayList<Book> bookEntities = new ArrayList<Book>();

	/**
	 * 使用 JDOM 方式，解析 xml 文件
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, JDOMException, IOException {
		JDOMTest test = new JDOMTest();
		test.createXML();
	}
	
	/**
	 * 创建 XML 文件
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void createXML() throws FileNotFoundException, IOException {
		// 创建一个根节点
		Element root = new Element("rss");
		// 设置一个属性
		root.setAttribute("version", "2.0");
		// 新建一个子节点
		Element channel = new Element("channel");
		Element title = new Element("title");
		title.setText("IT新闻");
		channel.addContent(title);
		// 通过 addContent() 方法将子节点添加进去
		root.addContent(channel);
		// 创建一个 Document 实例
		Document doc = new Document(root);
		// 新建一个 XMLOutputter 用来将 XML 内容写入文件中
		XMLOutputter output = new XMLOutputter();
		
		// 得到一个 format 实例，用来美化格式
		Format format = Format.getPrettyFormat();
		// 设置格式
		output.setFormat(format);
		// 通过 XMLOutputter 的 output 方法，将内容写入指定文件中
		output.output(doc, new FileOutputStream("demo/rssnews_2.xml"));
	}

	/**
	 * 解析 XML 文件
	 */
	public void parseXML() throws JDOMException, IOException,
			FileNotFoundException {
		// 获取一个 SAXBuilder 实例
		SAXBuilder sb = new SAXBuilder();
		// 获得一个 Document 实例
		Document doc = sb.build(new FileInputStream("demo/books.xml"));
		// 获取根节点信息
		Element root = doc.getRootElement();
		// 根据根节点信息获取子节点信息
		List<Element> books = root.getChildren();
		// 遍历子节点
		for (Element book : books) {
			System.out.println("----------开始扫描第" + (books.indexOf(book) + 1) + "本书----------");
			
			// 新建一个 book 实体
			bookEntity = new Book();
			
			// 获得该节点的全部属性
			List<Attribute> attrs = book.getAttributes();
			// 遍历这些属性
			for (Attribute attr : attrs) {
				System.out.println("属性名：" + attr.getName() + "----属性值：" + attr.getValue());
			}
			
			// 获得该节点的子节点
			List<Element> children = book.getChildren();
			// 遍历输出这些节点的属性名和属性值
			for (Element child : children) {
				String attrName = child.getName();
				String attrValue = child.getValue();
				System.out.println("子属性名：" + attrName + "----属性值：" + attrValue);
				// 为 book 实体添加属性
				if (attrName.equals("name")) {
					bookEntity.setName(attrValue);
				} else if (attrName.equals("author")) {
					bookEntity.setAuthor(attrValue);
				} else if (attrName.equals("year")) {
					bookEntity.setYear(attrValue);
				} else if (attrName.equals("price")) {
					bookEntity.setPrice(attrValue);
				} else if (attrName.equals("language")) {
					bookEntity.setLanguage(attrValue);
				}
			}
			
			// 将 book 实体添加到 ArrayList 中去
			bookEntities.add(bookEntity);
			bookEntity = null;
			System.out.println("--------------------------------");
		}
		
		// 遍历输出 bookEntities 中的 book 实体
		for (Book book : bookEntities) {
			System.out.println("==================");
			System.out.println(book.getAuthor());
			System.out.println(book.getLanguage());
			System.out.println(book.getName());
			System.out.println(book.getPrice());
			System.out.println(book.getYear());
			System.out.println("==================");
		}
	}

}
