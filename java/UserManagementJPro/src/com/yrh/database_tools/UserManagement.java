package com.yrh.database_tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManagement {

	/**
	 * 添加用户信息
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
	 * @param role
	 *            身份 1 表示管理员 2 表示普通用户
	 */
	public void add(String username, String password, int role) {

		// 声明连接对象
		Connection conn = DBConnection.getConnection();

		// 声明预编译对象
		PreparedStatement psmt = null;
		// 声明操作语句
		String sql = "insert into t_user (username, password, role)"
				+ " values(?, ?, ?)";
		System.out.println("保存用户信息："
				+ "insert into t_user (username, password, role)" + " values("
				+ username + ", " + password + ", " + role + ")");
		// 预编译sql
		try {
			psmt = conn.prepareStatement(sql);
			// 为占位符？设置值
			psmt.setString(1, username);
			psmt.setString(2, password);
			psmt.setInt(3, role);
			// 执行更新操作
			psmt.executeUpdate();

			// 关闭预编译语句
			DBConnection.closeStatement(psmt);
			// 关闭数据库连接
			DBConnection.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("系统异常，用户信息保存失败！");
		} finally {
			// 关闭预编译语句
			DBConnection.closeStatement(psmt);
			// 关闭数据库连接
			DBConnection.closeConnection(conn);
		}

	}

	/**
	 * 根据用户ID返回用户信息
	 * 
	 * @param id
	 *            用户ID
	 * @return 用户信息
	 */
	public String[] get(int id) {
		// 声明连接对象
		Connection conn = DBConnection.getConnection();

		// 声明预编译对象和结果集对象
		PreparedStatement psmt = null;
		ResultSet rs = null;

		// 声明用户信息数组
		String[] user = null;

		// 声明操作语句
		String sql = "select username, password, role from t_user where id=? and del=0";

		// 预编译sql
		try {
			psmt = conn.prepareStatement(sql);
			// 设置占位符'?'处的值
			psmt.setInt(1, id);
			// 获取查询结果集
			rs = psmt.executeQuery();
			// 当查询到结果集时用user数组保存用户信息
			if (rs.next()) {
				user = new String[3];
				user[0] = rs.getString("username");
				user[1] = rs.getString("password");
				user[2] = rs.getInt("role") + "";
			}
			DBConnection.closeResultSet(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("系统异常，请求未处理！");
		} finally {
			DBConnection.closeResultSet(rs);
		}

		return user;
	}

	public static void main(String[] args) {
		UserManagement user = new UserManagement();
		String[] result = user.get(1);
		if (result.length == 3) {
			System.out.println("+--------------------------------查询结果--------------------------------+");
			String role = null;
			if (result[2].equals("1")) {
				role = "管理员";
			} else {
				role = "普通用户";
			}
			System.out.println("|\t用户名：" + result[0] + "\t|\t密码：" + result[1]
					+ "\t|\t身份：" + role+"\t|");
			System.out.println("+-----------------------------------------------------------------------+");
		}
	}
}
