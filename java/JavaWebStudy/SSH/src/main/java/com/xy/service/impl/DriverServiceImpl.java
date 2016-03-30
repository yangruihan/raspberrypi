package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.DriverDaoInter;
import com.xy.model.Driver;
import com.xy.service.DriverServiceInter;

@Service("driverProxy")
public class DriverServiceImpl extends BaseServiceImpl<Driver> implements DriverServiceInter {
	@Autowired
	private DriverDaoInter driverDao;		//从容器中注入session工厂【无需get,set方法】
	
	
}
