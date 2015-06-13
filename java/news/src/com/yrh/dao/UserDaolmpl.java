package com.yrh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.yrh.model.User;
import com.yrh.utils.AppException;
import com.yrh.utils.DBUtil;

public class UserDaolmpl implements UserDao {

	public boolean isExist(String name) throws AppException {
		// 获得数据库连接
		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet result = null;
		boolean flag = false;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeQuery("Select name from t_user;");
			// 遍历判断是否有重名
			while (result.next()) {
				if (name.equals(result.getString("name"))) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.isExist");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(result);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(conn);
		}

		return flag;
	}

	public boolean add(User user) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		String sql = "insert into t_user(name, password, role, del) values(?,?,?,0)";
		boolean flag = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getName().toString());
			psmt.setString(2, user.getPassword().toString());
			psmt.setInt(3, user.getRole());
			psmt.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.add");
		} finally {
			// 关闭资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	public boolean check(User user) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String name = user.getName();
		String password = user.getPassword();
		String sql = "select password from t_user where name='" + name +"';";
		boolean flag = false;
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String str = rs.getString("password");
				if (str.equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.check");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
}
