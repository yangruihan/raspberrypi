package com.yrh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yrh.entity.Message;
import com.yrh.util.HibernateSessionFactory;

/**
 * ���ڴ������Message��ҵ���߼���
 * 
 * @author Yrh
 * 
 */
public class MessageDao {

	/**
	 * ���ݲ�����ѯ���ݿ���ƥ���Message��Ϣ
	 * @param command ָ���ȷ���ң�
	 * @param description ��ϸ��ģ��ƥ�䣩
	 * @return ��ѯ���Ľ��List
	 */
	public List<Message> queryMessageByAttr(String command, String description) {
		// ���û�в�ѯ������ֱ�ӷ������н��
		StringBuffer hql = new StringBuffer("from Message m where 1 = 1");
		if (command != null && !command.trim().equals("")) {
			hql.append(" and m.command = '" + command + "'");
		}
		if (description != null && !description.trim().equals("")) {
			hql.append(" and m.description like '%" + description + "%'");
		}
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
		List<Message> messageList = query.list();
		HibernateSessionFactory.closeSession();
		
		return messageList;
	}
}
