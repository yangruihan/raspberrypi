package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.SharingConfirmDaoInter;
import com.xy.model.Sharingcarconfirm;
import com.xy.service.SharingConfirmServiceInter;

@Service("sharingConfirmProxy")
public class SharingConfirmServiceImp extends BaseServiceImpl<Sharingcarconfirm> implements SharingConfirmServiceInter {
	@Autowired
	private SharingConfirmDaoInter sConfirmDao;		//从容器中注入session工厂【无需get,set方法】
	
}
