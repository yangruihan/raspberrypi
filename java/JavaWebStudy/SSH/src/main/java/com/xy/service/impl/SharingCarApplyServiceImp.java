package com.xy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.dao.SharingCarApplyDaoInter;
import com.xy.model.Sharingcarapply;
import com.xy.service.SharingCarApplyServiceInter;

@Service("sharingCarApplyProxy")
public class SharingCarApplyServiceImp extends BaseServiceImpl<Sharingcarapply> implements SharingCarApplyServiceInter {
	@Autowired
	private SharingCarApplyDaoInter sCarAppDao;		//从容器中注入session工厂【无需get,set方法】
	
}
