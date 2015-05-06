package com.yrh.database_tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	// URLΪ���ݿ������ַ���
	private static String URL = "jdbc:mysql://127.0.0.1:3306/userdb?useUnicode=true&amp;characterEncoding=utf-8";
	// ���ݿ��˺�
	private static String USER = "root";
	// ���ݿ�����
	private static String PASSWORD = "root";
	
	/**
	 * �������ݿ�����
	 * @return �������ӳɹ��������ݿ����Ӷ��󣬷��򷵻�null
	 */
	public static Connection getConnection() {
		Connection conn = null; // �������Ӷ���
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// �������ݿ�����
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("connect success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Database driver was not found!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connect failure!");
		}

		// �������ݿ����Ӷ���
		return conn;
	}
	
	/**
	 * �ر�����
	 * @param conn ���Ӷ���
	 * @return true �رճɹ� false �ر�ʧ��
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
	 * �ر�Ԥ�������
	 * @param psmt Ԥ�������
	 * @return true �رճɹ� false �ر�ʧ��
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
	 * �رս����
	 * @param rs ���������
	 * @return true �رճɹ� false �ر�ʧ��
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
