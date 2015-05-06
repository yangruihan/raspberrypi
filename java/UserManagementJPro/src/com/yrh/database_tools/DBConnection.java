package com.yrh.database_tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	// URL为数据库连接字符串
	private static String URL = "jdbc:mysql://127.0.0.1:3306/userdb?useUnicode=true&amp;characterEncoding=utf-8";
	// 数据库账号
	private static String USER = "root";
	// 数据库密码
	private static String PASSWORD = "root";
	
	/**
	 * 创建数据库连接
	 * @return 创建连接成功返回数据库连接对象，否则返回null
	 */
	public static Connection getConnection() {
		Connection conn = null; // 声明连接对象
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 创建数据库连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connect success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Database driver was not found!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connect failure!");
		}

		// 返回数据库连接对象
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn 连接对象
	 * @return true 关闭成功 false 关闭失败
	 */
	public static boolean closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 关闭预编译对象
	 * @param psmt 预编译对象
	 * @return true 关闭成功 false 关闭失败
	 */
	public static boolean closeStatement(PreparedStatement psmt) {
		try {
			if (psmt != null) {
				psmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * 关闭结果集
	 * @param rs 结果集对象
	 * @return true 关闭成功 false 关闭失败
	 */
	public static boolean closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
 	
}
