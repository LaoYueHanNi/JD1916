package com.briup.work.service;

import com.briup.work.bean.User;

public interface UserService {
	public void login(String username,String password) throws Exception;
	public void register(User user) throws Exception;
}
