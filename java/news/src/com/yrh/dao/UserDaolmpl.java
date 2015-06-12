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
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("Select name from t_user;");
			// 遍历判断是否有重名
			while (result.next()) {
				if (name.equals(result.getString("name"))) {
					return true;
				}
			}

			// 关闭资源
			DBUtil.closeResultSet(result);
			DBUtil.closeStatement(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 关闭连接
		DBUtil.closeConnection(conn);
		return false;
	}

	public boolean add(User user) throws AppException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into t_user(name, password, role, del) values(?,?,?,0)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getName().toString());
			psmt.setString(2, user.getPassword().toString());
			psmt.setInt(3, user.getRole());
			psmt.execute();
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
