package com.yrh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrh.service.NewsService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class DeleteNewsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); // ����������ݵ�����
		resp.setCharacterEncoding("UTF-8"); // ����������ݵı���
		req.setCharacterEncoding("UTF-8");
		String[] deleteNewsId = req.getParameter("newsDeleteId").trim().split(" ");
		for (String s : deleteNewsId) {
			int id = 0;
			try {
				id = Integer.parseInt(s);
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("toError");
			}
			try {
				if (NewsService.delete(id)) {
					System.out.println("ɾ�����ųɹ�");
					req.setAttribute("message", "ɾ���ɹ���");
					req.getRequestDispatcher("toMyNews").forward(req, resp);
				}
			} catch (AppException e) {
				System.out.println(e.getMessage());
				resp.sendRedirect("toError");
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
