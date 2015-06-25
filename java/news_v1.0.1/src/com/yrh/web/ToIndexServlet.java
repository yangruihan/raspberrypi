package com.yrh.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yrh.model.News;
import com.yrh.service.NewsService;
import com.yrh.service.NewsTypeService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class ToIndexServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			for (int i = 1; i <= NewsTypeService.getNewsTypeNumbers(); i ++) {
				ArrayList<News> news = NewsService.getNewsByKind(i);
				req.setAttribute("type" + i, news);
				news = NewsService.getReNews(5);
				req.setAttribute("reNews", news);
				news = NewsService.getHotNews(5);
				req.setAttribute("hotNews", news);
			}
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
