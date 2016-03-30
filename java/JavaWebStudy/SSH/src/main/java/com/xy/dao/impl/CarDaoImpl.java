package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.CarDaoInter;
import com.xy.model.Car;

@Repository("carDao")
public class CarDaoImpl extends BaseDaoImpl<Car> implements CarDaoInter{
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public CarDaoImpl() {
		super(Car.class);
	}

	
		
}
