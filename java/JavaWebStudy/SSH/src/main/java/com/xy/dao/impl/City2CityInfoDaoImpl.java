package com.xy.dao.impl;

import org.springframework.stereotype.Repository;

import com.xy.dao.City2CityInfoDaoInter;
import com.xy.model.City2cityinfo;

@Repository("city2CityInfoDao")
public class City2CityInfoDaoImpl extends BaseDaoImpl<City2cityinfo>  implements City2CityInfoDaoInter {
	//通过调用父类的构造函数指定clazz值，即实体类的类类型
	public City2CityInfoDaoImpl() {
		super(City2cityinfo.class);
	}
}
