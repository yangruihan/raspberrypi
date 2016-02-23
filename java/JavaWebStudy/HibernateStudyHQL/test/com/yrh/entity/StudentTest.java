package com.yrh.entity;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yrh.util.HibernateSessionFactory;

public class StudentTest {

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
	public void queryFromStudentByHQL() {
		String hql = "from Student";
		Query query = session.createQuery(hql);

		List<Student> list = query.list();

		for (Student student : list) {
			System.out.println("Student name: " + student.getGname()
					+ " Grade name: " + student.getGrade().getGname());
		}
	}

	@Test
	public void selectObjectArray() {
		String hql = "select s.gname, s.gender from Student s";
		Query query = session.createQuery(hql);

		List<Object[]> result = query.list();

		for (Object[] oo : result) {
			System.out.print("name:" + oo[0]);
			System.out.println(" gender:" + oo[1]);
		}
	}

	@Test
	public void selectObject() {
		String hql = "select s.gname from Student s";
		Query query = session.createQuery(hql);

		List<Object> result = query.list();

		for (Object o : result) {
			System.out.println("name:" + o);
		}
	}

	@Test
	public void selectList() {
		String hql = "select new list(s.gname, s.gender) from Student s";
		Query query = session.createQuery(hql);

		List<List> result = query.list();

		for (List list : result) {
			for (Object o : list) {
				System.out.print(o + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void selectMapIndex() {
		String hql = "select new map(s.gname, s.gender) from Student s";
		Query query = session.createQuery(hql);

		List<Map> result = query.list();

		for (Map m : result) {
			System.out.println(m.get("0") + " " + m.get("1"));
		}
	}

	@Test
	public void selectMapAlias() {
		String hql = "select new map(s.gname as name, s.gender as gender) from Student s";
		Query query = session.createQuery(hql);

		List<Map> result = query.list();

		for (Map m : result) {
			System.out.println(m.get("name") + " " + m.get("gender"));
		}
	}

	@Test
	public void testDistinct() {
		String hql = "select distinct s.gender from Student s";
		Query query = session.createQuery(hql);

		List<Object> result = query.list();

		for (Object o : result) {
			System.out.println("gender:" + o);
		}
	}
	
	@Test
	public void testWhereCase() {
		String hql = "from Student s where s.gname = '张三'";
		Query query = session.createQuery(hql);

		List<Student> result = query.list();

		for (Student s : result) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testWhereInBetween() {
		String hql = "from Student s where s.sid in (6, 9)";
		Query query = session.createQuery(hql);

		List<Student> result = query.list();

		for (Student s : result) {
			System.out.println(s);
		}
		
		hql = "from Student s where s.sid not between 6 and 10";
		query = session.createQuery(hql);

		result = query.list();

		for (Student s : result) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testWhereLike() {
		// _ 通配一个字符 
		// % 通配多个字符
		String hql = "from Student s where s.gname like '张_'"; 
		Query query = session.createQuery(hql);

		List<Student> result = query.list();

		for (Student s : result) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testWhereAndOr() {
		String hql = "from Student s where s.gname like '张_' and s.sid = 9";
		Query query = session.createQuery(hql);

		List<Student> result = query.list();

		for (Student s : result) {
			System.out.println(s);
		}
	}
}
