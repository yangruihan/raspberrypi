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

		resp.setContentType("text/html"); // ����������ݵ�����
		resp.setCharacterEncoding("UTF-8"); // ����������ݵı���
		req.setCharacterEncoding("utf-8");

		// ��ȡ�û���������
		String name = req.getParameter("name").toString();
		String password = req.getParameter("password").toString();

		if (name == null || password == null) {

		}

		if (name.equals("")) {
			req.setAttribute("message", "�û�������Ϊ��");
			req.getRequestDispatcher("toLogin").forward(req, resp);
		} else if (password.equals("")) {
			req.setAttribute("message", "���벻��Ϊ��");
			req.getRequestDispatcher("toLogin").forward(req, resp);
		} else {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			// ������֤
			try {
				if (UserService.login(user)) {
					// ��½�ɹ��������ݷ��� session ��
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
					// ��½ʧ�ܣ�����ʾ��Ϣ���� req �У����� ��¼ҳ��
					req.setAttribute("message", "�û������������");
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
