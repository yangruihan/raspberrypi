package com.yrh.service;

import java.util.List;

import com.yrh.dao.MessageDao;
import com.yrh.entity.Message;

/**
 * 用于处理关于Message的服务类
 * @author Yrh
 *
 */
public class MessageService {
	
	private MessageDao messageDao = null;
	
	public MessageService() {
		messageDao = new MessageDao();
	}
	
	/**
	 * 根据参数查询数据库中匹配的Message信息
	 * @param command 指令（精确查找）
	 * @param description 详细（模糊匹配）
	 * @return 查询到的结果List
	 */
	public List<Message> queryMessageByAttr(String command, String description) {
		return messageDao.queryMessageByAttr(command, description);
	}
}
