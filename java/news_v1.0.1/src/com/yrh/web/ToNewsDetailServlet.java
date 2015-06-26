package com.yrh.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yrh.model.News;
import com.yrh.model.User;
import com.yrh.service.NewsService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class ToNewsDetailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int newsid = Integer.parseInt(req.getParameter("newsid"));
		News news = new News();
		try {
			news = NewsService.getNewsById(newsid);
			news.setClick(news.getClick() + 1);
			NewsService.update(news);
			ArrayList<News> newsList = new ArrayList<News>();
			newsList = NewsService.getReNews(5);
			req.setAttribute("reNews", newsList);
			newsList = NewsService.getHotNews(5);
			req.setAttribute("hotNews", newsList);
		} catch (AppException e) {
			System.out.println(e.getMessage());
			resp.sendRedirect("toError");
		}
		req.setAttribute("news", news);
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
