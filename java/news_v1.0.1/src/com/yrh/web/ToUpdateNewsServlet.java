package com.yrh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ToUpdateNewsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String s = req.getParameter("newsUpdateId");
		if (!s.equals("")) {
			System.out.println("update");
			req.getRequestDispatcher("updateNews.jsp").forward(req, resp); 
		} else if (!(s = req.getParameter("newsDeleteId")).equals("")) {
			System.out.println("delete");
			req.getRequestDispatcher("deleteNews").forward(req, resp); 
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
