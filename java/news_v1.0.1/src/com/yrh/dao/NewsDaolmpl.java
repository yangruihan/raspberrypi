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
		String sql = "insert into t_news(user_id, newsType_id, title, author, keywords, source, content, createTime, click, state, del) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
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
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy年MM月dd日 HH时mm分ss秒");
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
	public ArrayList<News> getList(int state) throws AppException {
		ArrayList<News> newsList = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from t_news where state=" + state
				+ " and del=0 order by createTime desc;";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int newsType_id = rs.getInt("newsType_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String keywords = rs.getString("keywords");
				String source = rs.getString("source");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				int click = rs.getInt("click");
				int del = rs.getInt("del");
				News news = new News();
				news.setId(id);
				news.setUserId(user_id);
				news.setNewsTypeId(newsType_id);
				news.setTitle(title);
				news.setAuthor(author);
				news.setKeywords(keywords);
				news.setSource(source);
				news.setContent(content);
				news.setCreateTime(createTime.toString());
				news.setState(state);
				news.setClick(click);
				news.setDel(del);
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

	@Override
	public boolean setState(int id, int state) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		String sql = "update t_news set state=? where id=?;";
		boolean flag = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);
			psmt.setInt(2, id);
			psmt.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.NewsDaolmpl.setState");
		} finally {
			// 关闭资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public ArrayList<News> getNewsByType(int newsTypeId) throws AppException {
		ArrayList<News> newsList = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from t_news where newsType_id=" + newsTypeId
				+ " and state=1 and del=0 order by createTime desc;";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int newsType_id = rs.getInt("newsType_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String keywords = rs.getString("keywords");
				String source = rs.getString("source");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				int click = rs.getInt("click");
				int del = rs.getInt("del");
				int state = 1;
				News news = new News();
				news.setId(id);
				news.setUserId(user_id);
				news.setNewsTypeId(newsType_id);
				news.setTitle(title);
				news.setAuthor(author);
				news.setKeywords(keywords);
				news.setSource(source);
				news.setContent(content);
				news.setCreateTime(createTime.toString());
				news.setState(state);
				news.setClick(click);
				news.setDel(del);
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.getNewsByType");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public ArrayList<News> getReNews(int numbers) throws AppException {
		ArrayList<News> newsList = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from t_news where state=1 and del=0 order by createTime desc;";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int number = 1;
			while (rs.next() && (number++ < numbers)) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int newsType_id = rs.getInt("newsType_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String keywords = rs.getString("keywords");
				String source = rs.getString("source");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				int click = rs.getInt("click");
				int del = rs.getInt("del");
				News news = new News();
				news.setId(id);
				news.setUserId(user_id);
				news.setNewsTypeId(newsType_id);
				news.setTitle(title);
				news.setAuthor(author);
				news.setKeywords(keywords);
				news.setSource(source);
				news.setContent(content);
				news.setCreateTime(createTime.toString());
				news.setState(1);
				news.setClick(click);
				news.setDel(del);
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.getReNews");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public ArrayList<News> getHotNews(int numbers) throws AppException {
		ArrayList<News> newsList = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from t_news where state=1 and del=0 order by click desc;";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int number = 1;
			while (rs.next() && (number++ < numbers)) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int newsType_id = rs.getInt("newsType_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String keywords = rs.getString("keywords");
				String source = rs.getString("source");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				int click = rs.getInt("click");
				int del = rs.getInt("del");
				News news = new News();
				news.setId(id);
				news.setUserId(user_id);
				news.setNewsTypeId(newsType_id);
				news.setTitle(title);
				news.setAuthor(author);
				news.setKeywords(keywords);
				news.setSource(source);
				news.setContent(content);
				news.setCreateTime(createTime.toString());
				news.setState(1);
				news.setClick(click);
				news.setDel(del);
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.getReNews");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public ArrayList<News> getNewsByUserId(int id) throws AppException {
		ArrayList<News> newsList = new ArrayList<News>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from t_news where user_id=" + id
				+ ";";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int newsId = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int newsType_id = rs.getInt("newsType_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String keywords = rs.getString("keywords");
				String source = rs.getString("source");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				int click = rs.getInt("click");
				int del = rs.getInt("del");
				int state = rs.getInt("state");
				News news = new News();
				news.setId(newsId);
				news.setUserId(user_id);
				news.setNewsTypeId(newsType_id);
				news.setTitle(title);
				news.setAuthor(author);
				news.setKeywords(keywords);
				news.setSource(source);
				news.setContent(content);
				news.setCreateTime(createTime.toString());
				news.setState(state);
				news.setClick(click);
				news.setDel(del);
				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.getNewsByUserId");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	@Override
	public News getNewsById(int id) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = "select * from t_news where id=" + id + ";";
		News news = new News();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int newsId = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int newsType_id = rs.getInt("newsType_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String keywords = rs.getString("keywords");
				String source = rs.getString("source");
				String content = rs.getString("content");
				Date createTime = rs.getDate("createTime");
				int click = rs.getInt("click");
				int del = rs.getInt("del");
				int state = rs.getInt("state");
				news.setId(newsId);
				news.setUserId(user_id);
				news.setNewsTypeId(newsType_id);
				news.setTitle(title);
				news.setAuthor(author);
				news.setKeywords(keywords);
				news.setSource(source);
				news.setContent(content);
				news.setCreateTime(createTime.toString());
				news.setState(state);
				news.setClick(click);
				news.setDel(del);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.UserDaolmpl.getNewsByUserId");
		} finally {
			// 关闭资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return news;
	}

	@Override
	public boolean update(News news) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		String sql = "update t_news set newsType_id=?, title=?, author=?, keywords=?, source=?, content=?, click=? where id=?;";
		boolean flag = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, news.getNewsTypeId());
			psmt.setString(2, news.getTitle());
			psmt.setString(3, news.getAuthor());
			psmt.setString(4, news.getKeywords());
			psmt.setString(5, news.getSource());
			psmt.setString(6, news.getContent());
			psmt.setInt(7, news.getClick());
			psmt.setInt(8, news.getId());
			psmt.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.NewsDaolmpl.update");
		} finally {
			// 关闭资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean delete(int id) throws AppException {
		Connection conn = DBUtil.getConnection();
		PreparedStatement psmt = null;
		String sql = "delete from t_news where id=?;";
		boolean flag = false;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.yrh.dao.NewsDaolmpl.delete");
		} finally {
			// 关闭资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

}
