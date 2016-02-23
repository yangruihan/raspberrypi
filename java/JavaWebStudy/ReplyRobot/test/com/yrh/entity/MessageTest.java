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
		Message message1 = new Message("����", "�鿴��ǰ�������", "��ʱδʵ��������ѯ����");
		Message message2 = new Message("Ц��", "����ظ�һ��Ц��", "��ʱδʵ�ֻظ�Ц������");
		Message message3 = new Message("����", "�鿴��ǰ������������", "��ʱδʵ��������ѯ����");
		Message message4 = new Message("��ʳ", "����Ƽ�һ����ʳ", "��ʱδʵ����ʳ��ѯ����");
		
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
