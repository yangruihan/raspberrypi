package com.yrh.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库工具类
 * @author Yrh
 *
 */
public class DBUtil {

	public static String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
	public static String USER = "root";
	public static String PASSWORD = "root";
	
	public static Connection conn = null;

	static {
		try {
			// 1.加载数据库
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取连接
	 */
	public static Connection getConnection() {
		return conn;
	}

}
