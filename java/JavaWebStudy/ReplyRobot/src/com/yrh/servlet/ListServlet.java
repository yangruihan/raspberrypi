package com.yrh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yrh.entity.Message;
import com.yrh.service.MessageService;
import com.yrh.util.HibernateSessionFactory;

public class ListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		
		// 实例化一个消息服务类
		MessageService messageService = new MessageService();
		List<Message> messageList = messageService.queryMessageByAttr(command, description);
		
		if (messageList != null) {
			request.setAttribute("messageList", messageList);
		}

		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
