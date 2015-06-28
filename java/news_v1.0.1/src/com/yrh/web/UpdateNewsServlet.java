package com.yrh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yrh.model.News;
import com.yrh.service.NewsService;
import com.yrh.service.NewsTypeService;
import com.yrh.utils.AppException;

@SuppressWarnings("serial")
public class UpdateNewsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html"); // ����������ݵ�����
		resp.setCharacterEncoding("UTF-8"); // ����������ݵı���
		req.setCharacterEncoding("UTF-8");
		News news = new News();
		int id = 0;
		try {
			id = Integer.parseInt(req.getParameter("newsId"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resp.sendRedirect("toError");
		}
		String newsTitle = req.getParameter("newsTitle");
		String newsKind = req.getParameter("newsKind");
		String newsSource = req.getParameter("newsSource");
		String newsAuthor = req.getParameter("newsAuthor");
		String newsCreateTime = req.getParameter("newsCreateTime");
		String newsKeyword = req.getParameter("newsKeyword");
		String newsContent = req.getParameter("newsContent");

		if (id <= 0) {
			System.out.println("�޸�����ʧ�ܣ�id����");
			req.getRequestDispatcher("toError").forward(req, resp);
			return;
		} else {
			news.setId(id);
		}

		// ��������
		if (newsTitle != null && !newsTitle.trim().equals("")) {
			news.setTitle(newsTitle);
		} else {
			System.out.println("�޸�����ʧ�ܣ�ȱ�ٱ���");
			req.setAttribute("message", "ȱ�ٱ���");
			req.getRequestDispatcher("toUpdate").forward(req, resp);
			return;
		}
		if (newsKind != null) {
			try {
				news.setNewsTypeId(NewsTypeService.getNewsTypeId(newsKind));
			} catch (AppException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				req.getRequestDispatcher("toError").forward(req, resp);
			}
		} else {
			System.out.println("�޸�����ʧ�ܣ���ѡ����ȷ����������");
			req.setAttribute("message", "��ѡ����ȷ����������");
			req.getRequestDispatcher("toUpdate").forward(req, resp);
			return;
		}
		
		if (newsContent != null && !newsContent.trim().equals("")) {
			news.setContent(newsContent);
		} else {
			System.out.println("�޸�����ʧ�ܣ�û������");
			req.setAttribute("message", "û������");
			req.getRequestDispatcher("toUpdate").forward(req, resp);
			return;
		}
		
		if (newsSource != null) {
			news.setSource(newsSource);
		}
		
		if (newsAuthor != null) {
			news.setAuthor(newsAuthor);
		}
		
		if (newsCreateTime != null) {
			news.setCreateTime(newsCreateTime);
		}
		if (newsKeyword != null) {
			news.setKeywords(newsKeyword);
		}
		
		try {
			if (NewsService.update(news)) {
				System.out.println("�޸����ųɹ�");
				req.setAttribute("message", "�޸ĳɹ���");
				req.getRequestDispatcher("toMyNews").forward(req, resp);
			}
		} catch (AppException e) {
			System.out.println(e.getMessage());
			req.getRequestDispatcher("toError").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}