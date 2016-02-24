package com.yrh.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据库访问工具类
 * @author Yrh
 *
 */
public class DBAccess {

	/**
	 * 获得一个会话
	 */
	public SqlSession getSession() throws IOException {
		//读取配置信息
		Reader reader = Resources.getResourceAsReader("com/yrh/config/Configuration.xml");
		//通过配置信息生成SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//通过SqlSessionFactory打开会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
