package com.yrh.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yrh.model.User;
import com.yrh.service.UserService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html"); // 设置输出内容的类型
		resp.setCharacterEncoding("UTF-8"); // 设置输出内容的编码
		req.setCharacterEncoding("utf-8");

		// 获取用户名、密码
		String name = req.getParameter("name").toString();
		String password = req.getParameter("password").toString();

		if (name == null || password == null) {

		}

		if (name.equals("")) {
			req.setAttribute("message", "用户名不能为空");
			req.getRequestDispatcher("toLogin").forward(req, resp);
		} else if (password.equals("")) {
			req.setAttribute("message", "密码不能为空");
			req.getRequestDispatcher("toLogin").forward(req, resp);
		} else {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			// 进行验证
			try {
				if (UserService.login(user)) {
					// 登陆成功，将数据放入 session 中
					int role = UserService.getUserRole(name);
					HttpSession session = req.getSession();
					user.setId(UserService.getUserID(name));
					user.setRole(role);
					session.setAttribute("user", user);
					
					if (role == 0) {
						resp.sendRedirect("toEditor");
					} else if (role == 1) {
						resp.sendRedirect("toAdmin");
					} else {
						resp.sendRedirect("toNewUser");
					}
				} else {
					// 登陆失败，将提示信息放入 req 中，返回 登录页面
					req.setAttribute("message", "用户名或密码错误");
					req.getRequestDispatcher("toLogin").forward(req, resp);
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
