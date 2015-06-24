package com.yrh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.yrh.model.News;
import com.yrh.utils.AppException;
import com.yrh.utils.DBUtil;

public class NewsDaolmpl implements NewsDao {

	public boolean add(News news) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		String sql = "insert into t_news(id, user_id, newsType_id, title, author, keywords, source, content, createTime, click, state, del) " +
				"values(null,?,?,?,?,?,?,?,?,?,?,?)";
		boolean flag = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, news.getUserId());
			psmt.setInt(2, news.getNewsTypeId());
			psmt.setString(3, news.getTitle());
			psmt.setString(4, news.getAuthor());
			psmt.setString(5, news.getKeywords());
			psmt.setString(6, news.getSource());
			psmt.setString(7, news.getContent());
			SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			Date createTime = new Date();
			try {
				createTime = format.parse(news.getCreateTime());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new AppException("com.yrh.dao.NewsDaolmpl.add");
			}
			psmt.setTimestamp(8, new Timestamp(createTime.getTime()));
			psmt.setInt(9, news.getClick());
			psmt.setInt(10, news.getState());
			psmt.setInt(11, news.getDel());
			psmt.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.NewsDaolmpl.add");
		} finally {
			// 关闭资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public ArrayList<News> getList(int state)
			throws AppException {
		ArrayList<News> newsList = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select id,title,newsType_id from t_news where state=" + state +" and del=0 order by createTime desc;";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				int newsTypeId = rs.getInt("newsType_id");
				News news = new News();
				news.setId(id);
				news.setTitle(title);
				news.setState(state);
				news.setNewsTypeId(newsTypeId);
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.getRoleById");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

}
