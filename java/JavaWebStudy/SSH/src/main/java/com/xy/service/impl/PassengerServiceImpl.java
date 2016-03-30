package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.PassengerDaoInter;
import com.xy.model.Passenger;
import com.xy.service.PassengerServiceInter;

@Service("passengerProxy")
public class PassengerServiceImpl extends BaseServiceImpl<Passenger> implements PassengerServiceInter {
	@Autowired
	private PassengerDaoInter passengerDao;		//从容器中注入session工厂【无需get,set方法】
	
}
