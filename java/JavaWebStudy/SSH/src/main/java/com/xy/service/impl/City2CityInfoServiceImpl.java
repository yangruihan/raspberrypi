package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.City2CityInfoDaoInter;
import com.xy.model.City2cityinfo;
import com.xy.service.City2CityInfoServiceInter;

@Service("city2cityinfoProxy")
public class City2CityInfoServiceImpl extends BaseServiceImpl<City2cityinfo>  implements City2CityInfoServiceInter {
	@Autowired
	private City2CityInfoDaoInter c2cInfoDao;		//从容器中注入session工厂【无需get,set方法】
	
}
