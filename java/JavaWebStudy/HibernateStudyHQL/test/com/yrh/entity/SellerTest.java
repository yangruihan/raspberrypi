package com.yrh.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yrh.util.HibernateSessionFactory;

public class SellerTest {
	
	private Session session = null;
	
	@Before
	public void setUp() {
		session = HibernateSessionFactory.getSession();
	}

	@After
	public void tearUp() {
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void hqlFromTest() {
		String hql = "from Seller";
		Query query = session.createQuery(hql);
		
		List list = query.list();
		
		for (Object o: list){
			Seller seller = (Seller) o;
			System.out.println(seller);
		}
	}

}
