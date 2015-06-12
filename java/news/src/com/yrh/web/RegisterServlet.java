package com.yrh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yrh.model.User;
import com.yrh.service.UserService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); 	// 设置输出内容的类型
		resp.setCharacterEncoding("UTF-8");	// 设置输出内容的编码
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		// 获取用户名、密码和重复密码
		String name = req.getParameter("name").toString();
		String password = req.getParameter("password").toString();
		String password2 = req.getParameter("password2").toString();
		
		if (name == null || password == null || password2 == null) {
			req.setAttribute("result", "系统错误");
		}
		
		if (name.equals("") || password.equals("") || password2.equals("")) {
			req.setAttribute("result", "用户名或密码不能为空");
		} else if (!password.equals(password2)) {
			req.setAttribute("result", "两次密码输入不一致");
		} else {
			// 实例化一个 User 对象
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setRole(0);
			user.setDel(0);
			
			// 实例化一个 UserService 对象
			UserService userService = new UserService();
			try {
				if (userService.register(user)) {
					req.setAttribute("result", "注册成功");
				} else {
					req.setAttribute("result", "用户名已存在");
				}
			} catch (AppException e) {
				e.printStackTrace();
			}
		}
		
		req.getRequestDispatcher("/toregister").forward(req, resp);
//		resp.sendRedirect("toregister");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
