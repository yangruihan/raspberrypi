package com.yrh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.yrh.utils.AppException;
import com.yrh.utils.DBUtil;

public class NewsTypeDaolmpl implements NewsTypeDao {

	public int getIdByName(String name) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select id from t_newstype where name='" + name + "';";
		int id = 0;

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.NewsTypeDaolmpl.getIdByName");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return id;
	}

	@Override
	public String getNameById(int id) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select name from t_newstype where id='" + id + "';";
		String name = "";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.NewsTypeDaolmpl.getNameById");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return name;
	}

	@Override
	public int getNewsTypeNumbers() throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select count(*) count from t_newstype;";
		int count = 0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.NewsTypeDaolmpl.getNewsTypeNumbers");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return count;
	}

}
