package com.yrh.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yrh.entity.Grade;
import com.yrh.entity.Student;
import com.yrh.util.HibernateSessionFactory;

public class StudentTest {

	@Test
	public void addStudent() {
		Grade grade = new Grade("软产1班", "软件产业1301班");
		Student student1 = new Student("张三", "男");
		Student student2 = new Student("李四", "男");
		student1.setGrade(grade);
		student2.setGrade(grade);
		grade.getStudents().add(student1);
		grade.getStudents().add(student2);

		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();

		session.save(grade);
//		session.save(student1);
//		session.save(student2);

		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	@Test
	public void findStudentById() {
		Session session = HibernateSessionFactory.getSession();
		Student s = (Student) session.get(Student.class, 1);
		System.out.println(s);
		HibernateSessionFactory.closeSession();
	}

	@Test
	public void findStudentByGrade() {
		Session session = HibernateSessionFactory.getSession();

		Grade grade = (Grade) session.get(Grade.class, 1);
		System.out.println(grade);

		Set set = grade.getStudents();
		for (Object o : set) {
			Student s = (Student) o;
			System.out.println(s);
		}

		HibernateSessionFactory.closeSession();
	}

	@Test
	public void update() {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();

		Grade grade = new Grade("软件2班", "软件1302班");
		Student student = (Student) session.get(Student.class, 1);

		grade.getStudents().add(student);
		student.setGrade(grade);
		session.save(grade);
		session.update(student);

		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	@Test
	public void deleteStudent() {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();

		Student student = (Student) session.get(Student.class, 2);
		session.delete(student);

		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	@Test
	public void deleteGrade() {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();

		Grade grade = (Grade) session.get(Grade.class, 9);
//		Set set = grade.getStudents();
//		for (Object o : set) {
//			Student s = (Student) o;
//			session.delete(s);
//		}

		session.delete(grade);

		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
}
