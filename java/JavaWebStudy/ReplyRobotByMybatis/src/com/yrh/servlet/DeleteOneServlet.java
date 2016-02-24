package com.yrh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yrh.service.MessageService;

public class DeleteOneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("deleteId");
		MessageService messageService = new MessageService();
		
		if (messageService.deleteOneById(id)) {
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
