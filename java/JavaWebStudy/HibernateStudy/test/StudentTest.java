import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yrh.entity.Student;


public class StudentTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		// �������ö���
		Configuration configuration = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// �����Ự��������
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		// �Ự����
		session = sessionFactory.openSession();
		// ��������
		transaction = session.beginTransaction();
	}
	
	@After
	public void destory() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void test() {
		Student s1 = new Student(1, "С��", "��");
		Student s2 = new Student(2, "С��", "Ů");
		
		session.save(s1);
		session.save(s2);
	}

}
