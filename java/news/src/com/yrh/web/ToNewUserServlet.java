package com.yrh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ToNewUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); // ����������ݵ�����
		resp.setCharacterEncoding("UTF-8"); // ����������ݵı���
		PrintWriter out = resp.getWriter();
		String name = (String) req.getSession().getAttribute("name");
		
		if (name == null) {
			
		}
		if (name.equals("")) {
			
		}
		
		out.print("��ӭ����" + name);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
