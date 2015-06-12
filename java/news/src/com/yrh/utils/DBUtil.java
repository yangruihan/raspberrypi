package com.yrh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

/**
 * 数据库工具类
 * 
 * @author Yrh
 * 
 */
public class DBUtil {

	private static String URL = "jdbc:mysql://127.0.0.1:3306/newsdb?useUnicode=true&amp;"
			+ "characterEncoding-utf8"; // 数据库连接字符串
	private static String PASSWORD = "root"; // 数据库密码
	private static String USER = "root"; // 数据库用户名

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 创建数据库连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 */
	public void closeConnection(Connection conn) {
		try {
			if ((conn != null) && (!conn.isClosed())) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭状态
	 * @param state
	 */
	public void closeStatement(Statement state) {
		try {
			if ((state != null) && (!state.isClosed())) {
				state.close();
				state = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭结果集
	 * @param result
	 */
	public void closeResultSet(ResultSet result) {
		try {
			if ((result != null) && (!result.isClosed())) {
				result.close();
				result = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getConnection();
	}
}
