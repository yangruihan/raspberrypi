package com.yrh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yrh.model.News;
import com.yrh.model.User;
import com.yrh.service.NewsService;
import com.yrh.service.NewsTypeService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class CreateNewsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); // 设置输出内容的类型
		resp.setCharacterEncoding("UTF-8"); // 设置输出内容的编码
		req.setCharacterEncoding("UTF-8");

		News news = new News();
		String newsTitle = req.getParameter("newsTitle");
		String newsKind = req.getParameter("newsKind");
		String newsSource = req.getParameter("newsSource");
		String newsAuthor = req.getParameter("newsAuthor");
		String newsCreateTime = req.getParameter("newsCreateTime");
		String newsKeyword = req.getParameter("newsKeyword");
		String newsContent = req.getParameter("newsContent");

		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			news.setUserId(user.getId());
		}

		// 设置属性
		if (newsTitle != null && !newsTitle.trim().equals("")) {
			news.setTitle(newsTitle);
		} else {
			System.out.println("创建新闻失败：缺少标题");
			req.setAttribute("message", "缺少标题");
			req.getRequestDispatcher("toCreate").forward(req, resp);
			return;
		}
		if (newsKind != null) {
			try {
				news.setNewsTypeId(NewsTypeService.getNewsTypeId(newsKind));
			} catch (AppException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				req.getRequestDispatcher("toError").forward(req, resp);
			}
		} else {
			System.out.println("创建新闻失败：请选择正确的新闻类型");
			req.setAttribute("message", "请选择正确的新闻类型");
			req.getRequestDispatcher("toCreate").forward(req, resp);
			return;
		}
		if (newsSource != null) {
			news.setSource(newsSource);
		}
		if (newsAuthor != null) {
			news.setAuthor(newsAuthor);
		}
		if (newsCreateTime != null) {
			news.setCreateTime(newsCreateTime);
		}
		if (newsKeyword != null) {
			news.setKeywords(newsKeyword);
		}
		if (newsContent != null && !newsContent.trim().equals("")) {
			news.setContent(newsContent);
		} else {
			System.out.println("创建新闻失败：没有内容");
			req.setAttribute("message", "没有内容");
			req.getRequestDispatcher("toCreate").forward(req, resp);
			return;
		}
		try {
			if (NewsService.create(news)) {
				System.out.println("创建新闻成功");
				req.setAttribute("message", "创建成功！");
				req.getRequestDispatcher("toCreate").forward(req, resp);
			}
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.getRequestDispatcher("toError").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
