package com.xy.service;

import com.xy.model.User;

public interface UserServiceInter extends BaseServiceInter<User>{
	//扩展的方法
	public void transaction();
}
