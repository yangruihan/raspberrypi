package com.yrh.entity;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yrh.util.HibernateSessionFactory;

public class MessageTest {
	
	private Session session = null;

	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getSession();
	}

	@After
	public void tearDown() throws Exception {
		HibernateSessionFactory.closeSession();
	}

	@Test
	public void testAdd() {
		Message message1 = new Message("天气", "查看当前天气情况", "暂时未实现天气查询功能");
		Message message2 = new Message("笑话", "随机回复一条笑话", "暂时未实现回复笑话功能");
		Message message3 = new Message("体育", "查看当前精彩体育赛事", "暂时未实现体育查询功能");
		Message message4 = new Message("美食", "随机推荐一款美食", "暂时未实现美食查询功能");
		
		Transaction transaction = session.beginTransaction();
		
		session.save(message1);
		session.save(message2);
		session.save(message3);
		session.save(message4);
		
		transaction.commit();
	}
	
	@Test
	public void testGet() {
		String hql = "from Message";
		Query query = session.createQuery(hql);
		List<Message> messageList = query.list();
		
		for (Message message : messageList) {
			System.out.println(message);
		}
	}

}
