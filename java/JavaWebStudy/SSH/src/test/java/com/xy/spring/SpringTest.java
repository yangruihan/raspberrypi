package com.xy.spring;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xy.model.City2cityinfo;
import com.xy.service.BaseServiceInter;
import com.xy.service.UserServiceInter;
import com.xy.util.PageModel;
import com.xy.util.QueryResult;


public class SpringTest {
    ApplicationContext ac = null;
	
    @Before
	public void init(){
		ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test1(){
		BaseServiceInter baseServiceInter = (BaseServiceInter)ac.getBean("city2cityinfoProxy");
		QueryResult<Object> queryResult = baseServiceInter.load(1, 10);
		for (Object object : queryResult.getDatas()) {
			System.out.println(object);
		}
		System.out.println(queryResult.getTotalCount());
	}

	@Test
	public void test2(){
		UserServiceInter userProxy = (UserServiceInter)ac.getBean("userProxy");
		System.out.println(userProxy.deleteById(1));;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test3(){
		BaseServiceInter baseServiceInter = (BaseServiceInter)ac.getBean("city2cityinfoProxy");
		QueryResult result = (QueryResult) baseServiceInter.load(1, 20);
		PageModel pageModel = new PageModel();
		pageModel.setResults(result);
		System.out.println(pageModel.getCurrentPage());
		System.out.println(pageModel.getPageSize());
		System.out.println(pageModel.getTotalPage());
		System.out.println(pageModel.getResults().getTotalCount());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test4(){
		BaseServiceInter baseServiceInter = (BaseServiceInter)ac.getBean("city2cityinfoProxy");
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("oilCost", "DESC");
		QueryResult result = baseServiceInter.getScrollData(0, 1, orderby);
		System.out.println(result.getTotalCount());
		System.out.println(((City2cityinfo)result.getDatas().get(0)).getId());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test5(){
		BaseServiceInter baseServiceInter = (BaseServiceInter)ac.getBean("city2cityinfoProxy");
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("oilCost", "DESC");
		String where = "o.oilCost>? and o.oilCost<?";
		Float[] params = {100.0f,1000.0f};
		QueryResult result = baseServiceInter.getScrollData(0, 1, where, params,orderby);
		System.out.println(result.getTotalCount());
		System.out.println(((City2cityinfo)result.getDatas().get(0)).getId());
	}
	
}
