package com.yrh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yrh.entity.Message;
import com.yrh.util.HibernateSessionFactory;

/**
 * 用于处理关于Message的业务逻辑类
 * 
 * @author Yrh
 * 
 */
public class MessageDao {

	/**
	 * 根据参数查询数据库中匹配的Message信息
	 * @param command 指令（精确查找）
	 * @param description 详细（模糊匹配）
	 * @return 查询到的结果List
	 */
	public List<Message> queryMessageByAttr(String command, String description) {
		// 如果没有查询参数则直接返回所有结果
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
