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
public class ToMyNewsServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			User user = (User)req.getSession().getAttribute("user");
			int id = user.getId();
			ArrayList<News> newsList = NewsService.getNewsByUserId(id);
			req.setAttribute("myNews", newsList);
		} catch (AppException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.getRequestDispatcher("toError").forward(req, resp);
		}
		req.getRequestDispatcher("myNews.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
