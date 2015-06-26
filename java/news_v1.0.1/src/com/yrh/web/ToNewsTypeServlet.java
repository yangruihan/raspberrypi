package com.yrh.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrh.model.News;
import com.yrh.service.NewsService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class ToNewsTypeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int newsType = Integer.parseInt(req.getParameter("typeid"));
		ArrayList<News> newsList = new ArrayList<News>();
		try {
			newsList = NewsService.getNewsByKind(newsType);
			req.setAttribute("newsList", newsList);
			newsList = NewsService.getReNews(5);
			req.setAttribute("reNews", newsList);
			newsList = NewsService.getHotNews(5);
			req.setAttribute("hotNews", newsList);
		} catch (AppException e) {
			System.out.println(e.getMessage());
			resp.sendRedirect("toError");
		}
		req.getRequestDispatcher("newsType.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
