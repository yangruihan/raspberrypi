package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.DriverDaoInter;
import com.xy.model.Driver;

@Repository(value="driverDao")
public class DriverDaoImpl extends BaseDaoImpl<Driver> implements DriverDaoInter{
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public DriverDaoImpl() {
		super(Driver.class);
	}
	
}
