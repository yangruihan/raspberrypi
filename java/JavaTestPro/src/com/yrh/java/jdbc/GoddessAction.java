package com.yrh.java.jdbc;

import java.util.ArrayList;
import java.util.Date;

public class GoddessAction {

	public static void main(String[] args) throws Exception {
		GoddessDao goddessDao = new GoddessDao();
//		ArrayList<Goddess> list = (ArrayList<Goddess>) goddessDao.queryGoddess();
//		for (Goddess goddess : list) {
//			System.out.println(goddess.getName() + "," + goddess.getAge());
//		}
		
		Goddess g = new Goddess();
		g.setName("小红");
		g.setAge(22);
		g.setSex(1);
		g.setBirthday(new Date());
		g.setEmail("12314@qq.com");
		g.setMobile("17412341234");
		g.setCreate_user("admin");
		g.setUpdate_user("admin");
		g.setIsdel(0);
		
		goddessDao.addGoddess(g);
	}
}
