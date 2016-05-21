package com.yangruihan.nutz;

import org.nutz.dao.Dao;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.nutz.resource.Scans;

public class MySetup implements Setup {
	
	private static final Log log = Logs.get();
	
	@Override
	public void init(NutConfig nc) {
		log.debug("config ioc = " + nc.getIoc());
		
		// 创建数据库表
		Dao dao = nc.getIoc().get(Dao.class);
		
		for (Class<?> klass : Scans.me().scanPackage("com.yangruihan.nutz")) {
			if (klass.getAnnotation(Table.class) != null) {
				dao.create(klass, false);
			}
		}
	}
	
	@Override
	public void destroy(NutConfig nc) {
		
	}
}
