package com.yrh.web;

import java.io.IOException;
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
		resp.setContentType("text/html"); 	// ����������ݵ�����
		resp.setCharacterEncoding("UTF-8");	// ����������ݵı���
		req.setCharacterEncoding("utf-8");
		
		// ��ȡ�û�����������ظ�����
		String name = req.getParameter("name").toString();
		String password = req.getParameter("password").toString();
		String password2 = req.getParameter("password2").toString();
		
		if (name == null || password == null || password2 == null) {
			req.setAttribute("result", "ϵͳ����");
		}
		
		if (name.equals("") || password.equals("") || password2.equals("")) {
			req.setAttribute("result", "�û��������벻��Ϊ��");
		} else if (!password.equals(password2)) {
			req.setAttribute("result", "�����������벻һ��");
		} else {
			// ʵ����һ�� User ����
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setRole(0);
			user.setDel(0);
			
			try {
				if (UserService.register(user)) {
					req.setAttribute("result", "ע��ɹ�");
					req.getRequestDispatcher("toLogin").forward(req, resp);
				} else {
					req.setAttribute("result", "�û����Ѵ���");
				}
			} catch (AppException e) {
				System.out.println(e.getMessage());
				resp.sendRedirect("toError");
			}
		}
		
		req.getRequestDispatcher("toRegister").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}