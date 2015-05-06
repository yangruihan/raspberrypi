package com.yrh.database_tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {

	/**
	 * ����û���Ϣ
	 * 
	 * @param name
	 *            �û���
	 * @param password
	 *            ����
	 * @param role
	 *            ��� 1 ��ʾ����Ա 2 ��ʾ��ͨ�û�
	 */
	public void add(String username, String password, int role) {

		// �������Ӷ���
		Connection conn = DBConnection.getConnection();

		// ����Ԥ�������
		PreparedStatement psmt = null;
		// �����������
		String sql = "insert into t_user (username, password, role)"
				+ " values(?, ?, ?)";
		System.out.println("�����û���Ϣ��"
				+ "insert into t_user (username, password, role)" + " values("
				+ username + ", " + password + ", " + role + ")");
		// Ԥ����sql
		try {
			psmt = conn.prepareStatement(sql);
			// Ϊռλ��������ֵ
			psmt.setString(1, username);
			psmt.setString(2, password);
			psmt.setInt(3, role);
			// ִ�и��²���
			psmt.executeUpdate();

			// �ر�Ԥ�������
			DBConnection.closeStatement(psmt);
			// �ر����ݿ�����
			DBConnection.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ϵͳ�쳣���û���Ϣ����ʧ�ܣ�");
		} finally {
			// �ر�Ԥ�������
			DBConnection.closeStatement(psmt);
			// �ر����ݿ�����
			DBConnection.closeConnection(conn);
		}

	}

	/**
	 * �����û�ID�����û���Ϣ
	 * 
	 * @param id
	 *            �û�ID
	 * @return �û���Ϣ
	 */
	public String[] get(int id) {
		// �������Ӷ���
		Connection conn = DBConnection.getConnection();

		// ����Ԥ�������ͽ��������
		PreparedStatement psmt = null;
		ResultSet rs = null;

		// �����û���Ϣ����
		String[] user = null;

		// �����������
		String sql = "select username, password, role from t_user where id=? and del=0";

		// Ԥ����sql
		try {
			psmt = conn.prepareStatement(sql);
			// ����ռλ��'?'����ֵ
			psmt.setInt(1, id);
			// ��ȡ��ѯ�����
			rs = psmt.executeQuery();
			// ����ѯ�������ʱ��user���鱣���û���Ϣ
			if (rs.next()) {
				user = new String[3];
				user[0] = rs.getString("username");
				user[1] = rs.getString("password");
				user[2] = rs.getInt("role") + "";
			}
			DBConnection.closeResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ϵͳ�쳣������δ����");
		} finally {
			DBConnection.closeResultSet(rs);
		}

		return user;
	}

	public static void main(String[] args) {
		UserManagement user = new UserManagement();
		String[] result = user.get(1);
		if (result.length == 3) {
			System.out.println("+--------------------------------��ѯ���--------------------------------+");
			String role = null;
			if (result[2].equals("1")) {
				role = "����Ա";
			} else {
				role = "��ͨ�û�";
			}
			System.out.println("|\t�û�����" + result[0] + "\t|\t���룺" + result[1]
					+ "\t|\t��ݣ�" + role+"\t|");
			System.out.println("+-----------------------------------------------------------------------+");
		}
	}
}
