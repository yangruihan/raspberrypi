package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.PassengerDaoInter;
import com.xy.model.Passenger;

@Repository("passengerDao")
public class PassengerDaoImpl extends BaseDaoImpl<Passenger> implements PassengerDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public PassengerDaoImpl() {
		super(Passenger.class);
	}
	
}
