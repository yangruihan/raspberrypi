package com.yrh.entity;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yrh.util.HibernateSessionFactory;

public class GradeTest {

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
	public void testWhereEmpty() {
		String hql = "from Grade g where g.students is empty";
		Query query = session.createQuery(hql);
		
		List<Grade> result = query.list();
		for (Grade grade : result) {
			System.out.println(grade);
		}
	}

}
