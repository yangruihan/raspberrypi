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
		resp.setContentType("text/html"); // ����������ݵ�����
		resp.setCharacterEncoding("UTF-8"); // ����������ݵı���

		HttpSession session = req.getSession();
		// �Ƴ��ѵ�¼���û�
		if (session.getAttribute("name") != null) {
			session.removeAttribute("name");
		}
		System.out.println("ע���ɹ�");

		resp.sendRedirect("toLogin");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
