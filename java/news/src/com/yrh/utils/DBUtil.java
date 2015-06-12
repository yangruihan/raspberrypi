package com.yrh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

/**
 * ���ݿ⹤����
 * 
 * @author Yrh
 * 
 */
public class DBUtil {

	private static String URL = "jdbc:mysql://127.0.0.1:3306/newsdb?useUnicode=true&amp;"
			+ "characterEncoding-utf8"; // ���ݿ������ַ���
	private static String PASSWORD = "root"; // ���ݿ�����
	private static String USER = "root"; // ���ݿ��û���

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// �������ݿ�����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �ر�����
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
	 * �ر�״̬
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
	 * �رս����
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
