package com.briup.work.dao;

import java.sql.SQLException;

import com.briup.work.bean.User;

public interface UserDao {
	//����user
	public void inserUser(User user) throws Exception;
	//��ѯuser
	public User findUserByName(String name) throws Exception;
}
