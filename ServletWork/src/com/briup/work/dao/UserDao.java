package com.briup.work.dao;

import java.sql.SQLException;

import com.briup.work.bean.User;

public interface UserDao {
	//≤Â»Îuser
	public void inserUser(User user) throws Exception;
	//≤È—Øuser
	public User findUserByName(String name) throws Exception;
}
