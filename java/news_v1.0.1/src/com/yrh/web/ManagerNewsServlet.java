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
		resp.setContentType("text/html"); // 设置输出内容的类型
		resp.setCharacterEncoding("UTF-8"); // 设置输出内容的编码
		req.setCharacterEncoding("UTF-8");

		String[] passid = req.getParameter("passid").toString().trim()
				.split(" ");
		
		int count = 0;
		for (String s : passid) {
			try {
				int id = Integer.parseInt(s);
				if (NewsService.setState(id, 1)) {
					count++;
				} else {
					req.setAttribute("message", "审核失败");
					req.getRequestDispatcher("toManagerNews")
							.forward(req, resp);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				resp.sendRedirect("toError");
			}
		}
		if (count > 0) {
			if (count == passid.length) {
				req.setAttribute("message", "全部审核成功");
				req.getRequestDispatcher("toManagerNews").forward(req, resp);
			} else if (count < passid.length) {
				req.setAttribute("message", "部分审核成功");
				req.getRequestDispatcher("toManagerNews").forward(req, resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
