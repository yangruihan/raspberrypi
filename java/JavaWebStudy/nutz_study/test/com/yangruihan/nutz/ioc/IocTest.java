package com.yangruihan.nutz.ioc;

import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.alibaba.druid.pool.DruidDataSource;
import com.yangruihan.nutz.module.UserModule;

public class IocTest {

	@Test
	public void testConvertMVCIocBy() throws ClassNotFoundException {
		ComboIocLoader loader = new ComboIocLoader(new String[]{ 
				"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
				"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "com.yangruihan.nutz" 
		});
		
		NutIoc ioc = new NutIoc(loader);
		Dao dao = ioc.get(Dao.class);
		System.out.println(dao);
		
		UserModule module = ioc.get(UserModule.class);
		System.out.println(module.ping());
	}
	
	@Test
	public void testJsIoc() {
		JsonLoader loader = new JsonLoader("ioc/");
		NutIoc ioc = new NutIoc(loader);
		Dao dao = ioc.get(Dao.class);
		System.out.println(dao);
	}
	
	@Test
	public void testConvertJsIoc() {
		DruidDataSource dataSource = null;
		
		try {
			dataSource = new DruidDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql:///nutz_test?useUnicode=true&amp;characterEncoding=UTF-8");
			dataSource.setUsername("root");
			dataSource.setPassword("123456");
			
			NutDao dao = new NutDao(dataSource);
			System.out.println(dao);
		} finally {
			if (dataSource != null) {
				dataSource.close();
			}
		}
	}
}
