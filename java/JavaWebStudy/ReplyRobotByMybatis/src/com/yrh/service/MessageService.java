package com.yrh.service;

import java.util.ArrayList;
import java.util.List;

import com.yrh.dao.MessageDao;
import com.yrh.entity.Message;
import com.yrh.util.Constants;

/**
 * 消息服务类
 * 
 * @author Yrh
 * 
 */
public class MessageService {

	private MessageDao messageDao = null;

	public MessageService() {
		messageDao = new MessageDao();
	}

	/**
	 * 通过参数查询消息
	 */
	public List<Message> queryMessageByAttr(String command, String description) {
		return messageDao.queryMessageByAttr(command, description);
	}
	
	/**
	 * 通过命令得到回复内容 
	 */
	public String getContentByCommand(String command) {
		List<Message> resultList = messageDao.queryMessageByAttr(command, null);
		if (resultList.size() > 0) {
			return resultList.get(0).getContent();
		}
		return Constants.DEFAULT_REPLY;
	}

	/**
	 * 通过id查找一条消息
	 */
	public boolean deleteOneById(String id) {
		if (id != null && !"".equals(id.trim())) {
			try {
				return messageDao.deleteOneById(Integer.valueOf(id));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 通过id查找一组消息
	 */
	public boolean deleteListById(String ids) {
		if (ids != null && !"".equals(ids.trim())) {
			List<Integer> idList = new ArrayList<>();
			String[] idStrings = ids.trim().split(",");
			try {
				for (String string : idStrings) {
					idList.add(Integer.parseInt(string));
				}
				return messageDao.deleteListById(idList);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
