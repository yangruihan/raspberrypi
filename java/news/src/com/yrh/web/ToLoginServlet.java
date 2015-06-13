package com.yrh.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ToLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html"); // ����������ݵ�����
		resp.setCharacterEncoding("UTF-8"); // ����������ݵı���
		PrintWriter out = resp.getWriter();

		out.print("<html>");

		out.print("<body>");
		out.print("<form action=\"login\" name=\"tologin\" method=\"post\">");
		out.print("<table>");

		out.print("<tr>");
		out.print("<td>�û�����</td>");
		String username = req.getParameter("name");
		if (username != null) {
			out.print("<td><input type=\"text\" name=\"name\" value=\""
					+ username + "\"/></td>");
		} else {
			out.print("<td><input type=\"text\" name=\"name\"/></td>");
		}
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td>���룺</td>");
		out.print("<td><input type=\"password\" name=\"password\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td colspan=\"2\">");
		out.print("<input type=\"submit\" name=\"click\" value=\"��¼\">");
		out.print("</tr>");

		out.print("</table>");
		out.print("</form>");
		
		String message = (String) req.getAttribute("message");
		if (message != null) {
			out.print("<font color=\"#FF0000\">" + message + "</font>");
		}

		out.print("</body>");
		out.print("</html>");

		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
