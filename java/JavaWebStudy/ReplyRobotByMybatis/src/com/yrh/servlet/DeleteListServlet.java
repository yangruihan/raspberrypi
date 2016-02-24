package com.yrh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrh.service.MessageService;

public class DeleteListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("deleteIds");
		MessageService messageService = new MessageService();
		if (messageService.deleteListById(ids)) {
			System.out.println("INFO-------------------ɾ��ɹ�");
		} else {
			System.out.println("INFO-------------------ɾ��ʧ��");
		}
		
		request.getRequestDispatcher("/servlet/List.action").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
