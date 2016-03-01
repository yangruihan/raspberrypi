package com.yrh.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed......");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String initParam = arg0.getServletContext().getInitParameter("initParam");
		System.out.println("contextInitialized...... iniParam: " + initParam);
	}

}
