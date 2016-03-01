package com.yrh.service;

import java.util.List;

import com.yrh.dao.MessageDao;
import com.yrh.entity.Message;

/**
 * ���ڴ������Message�ķ�����
 * @author Yrh
 *
 */
public class MessageService {
	
	private MessageDao messageDao = null;
	
	public MessageService() {
		messageDao = new MessageDao();
	}
	
	/**
	 * ���ݲ�����ѯ���ݿ���ƥ���Message��Ϣ
	 * @param command ָ���ȷ���ң�
	 * @param description ��ϸ��ģ��ƥ�䣩
	 * @return ��ѯ���Ľ��List
	 */
	public List<Message> queryMessageByAttr(String command, String description) {
		return messageDao.queryMessageByAttr(command, description);
	}
}
