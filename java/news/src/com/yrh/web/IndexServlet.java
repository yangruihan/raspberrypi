package com.yrh.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����û�����������ҳ��
 * @author Yrh
 *
 */
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); 	// ����������ݵ�����
		resp.setCharacterEncoding("UTF-8");	// ����������ݵı���
		PrintWriter out = resp.getWriter();	// ���һ���������
		// ...���ͷ������
		// ...�����׼�� HTML �ṹ
		// ҳ��������Ϣ
		out.println("��ӭ��������ϵͳ��");
		// �ر������
		out.flush();
		out.close();
	}
}
