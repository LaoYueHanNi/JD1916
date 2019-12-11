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
					System.out.println("��½�ɹ�");
				} else
					throw new Exception("�������");
			} else
				throw new Exception("�û���δע��");
		} else
			throw new Exception("�û���������Ϊ��");
	}

	@Override
	public void register(User user) throws Exception {
		User findUser = userDao.findUserByName(user.getUsername());
		if (findUser.getUsername() == null) {
			// ����ע��
			userDao.inserUser(user);
			System.out.println("����ɹ�");
		} else
			throw new Exception("�û����Ѿ�����");
	}

}
