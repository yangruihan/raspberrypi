package com.yrh.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); // 设置输出内容的类型
		resp.setCharacterEncoding("UTF-8"); // 设置输出内容的编码

		HttpSession session = req.getSession();
		// 移除已登录的用户
		if (session.getAttribute("name") != null) {
			session.removeAttribute("name");
		}
		System.out.println("注销成功");

		resp.sendRedirect("toLogin");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
