package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.CarDaoInter;
import com.xy.model.Car;
import com.xy.service.CarServiceInter;

@Service("carProxy")
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarServiceInter {
	@Autowired
	private CarDaoInter carDao;		//从容器中注入session工厂【无需get,set方法】
	
	
}
