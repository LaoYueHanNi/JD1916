package com.briup.work.service;

import com.briup.work.bean.User;
import com.briup.work.dao.UserDao;
import com.briup.work.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() throws Exception {
		userDao = new UserDaoImpl();
	}

	@Override
	public void login(String username, String password) throws Exception {
		User user = userDao.findUserByName(username);
		if (username != "" && password != "") {
			if (user.getUsername() != null) {
				if (user.getPassword().equals(password)) {
					System.out.println("登陆成功");
				} else
					throw new Exception("密码错误");
			} else
				throw new Exception("用户名未注册");
		} else
			throw new Exception("用户名或密码为空");
	}

	@Override
	public void register(User user) throws Exception {
		User findUser = userDao.findUserByName(user.getUsername());
		if (findUser.getUsername() == null) {
			// 可以注册
			userDao.inserUser(user);
			System.out.println("插入成功");
		} else
			throw new Exception("用户名已经存在");
	}

}
