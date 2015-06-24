package com.yrh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yrh.service.NewsService;

@SuppressWarnings("serial")
public class ManagerNewsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); // ����������ݵ�����
		resp.setCharacterEncoding("UTF-8"); // ����������ݵı���
		req.setCharacterEncoding("UTF-8");
		
		String[] passid = req.getParameter("passid").toString().trim().split(" ");
		for (String s : passid) {
			try {
				int id = Integer.parseInt(s);
				NewsService.setState(id, 1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				resp.sendRedirect("toError");
			}
		}
		resp.sendRedirect("index");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
