package com.yrh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		String[] skipUrl = config.getInitParameter("skipUrl").split(";");

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		// 如果已经登录成功，则放行
		if (request.getSession().getAttribute("username") != null) {
			arg2.doFilter(arg0, arg1);
			return;
		}

		if (skipUrl != null && skipUrl.length > 0) {
			for (String url : skipUrl) {
				if (request.getRequestURI().indexOf(url) != -1) {
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
