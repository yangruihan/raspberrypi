package com.yrh.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yrh.entity.Message;
import com.yrh.util.DBAccess;

/**
 * 消息逻辑类
 * 
 * @author Yrh
 * 
 */
public class MessageDao {

	/**
	 * 通过参数查询消息
	 */
	public List<Message> queryMessageByAttr(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messages = new ArrayList<>();
		SqlSession sqlSession = null;
		try {
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			sqlSession = dbAccess.getSession();
			messages = sqlSession.selectList("Message.queryMessageByAttr",
					message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return messages;
	}

	/**
	 * 通过id查找一条消息
	 */
	public boolean deleteOneById(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSession();
			sqlSession.delete("Message.deleteOneById", id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return false;
	}

	/**
	 * 通过id查找一组消息
	 */
	public boolean deleteListById(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSession();
			sqlSession.delete("Message.deleteListById", ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return false;
	}
}
