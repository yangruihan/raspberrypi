package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.SharingCarInfoDaoInter;
import com.xy.model.Sharingcarinfo;
import com.xy.service.SharingCarInfoServiceInter;

@Service("sharingCarInfoProxy")
public class SharingCarInfoServiceImp extends BaseServiceImpl<Sharingcarinfo> implements SharingCarInfoServiceInter {
	@Autowired
	private SharingCarInfoDaoInter sCarInfoDao;		//从容器中注入session工厂【无需get,set方法】
	
}
