package com.yangruihan.nutz.module;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

@IocBean
@At("/usr")
public class UserModule {

	private static final Log log = Logs.get();
	
	@Inject
	private Dao dao;
	
	@At("/login")
	public boolean login(@Param("name")String name, @Param("passwd")String passwd) {
		log.debug("name:" + name + " passwd:" + passwd);
		return true;
	}
	
	@At("/ping")
	public Object ping() {
		log.debug("Dao == " + dao);
		return new Date();
	}
}
