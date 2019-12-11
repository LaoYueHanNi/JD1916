package com.briup.work.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.work.bean.User;

public class UserDaoImpl implements UserDao {
	private Connection conn;

	public UserDaoImpl() throws Exception {
		conn = DBTest.getConnection();
	}

	@Override
	public void inserUser(User user) throws Exception {
		// 插入user,往表种添加数据,首先建立连接
		Statement statement = conn.createStatement();
		String sql = "insert into jd_user values(user_seq.nextval,'" + user.getUsername() + "','" + user.getPassword()
				+ "','" + user.getGender() + "'," + user.getAge() + ",'" + user.getHobby() + "','" + user.getCity()
				+ "','" + user.getMotto() + "')";
		statement.execute(sql);
		System.out.println("插入成功");
	}

	@Override
	public User findUserByName(String username) throws SQLException {
		// TODO Auto-generated method stub
		Statement statement = conn.createStatement();
		String sql ="select * from jd_user where username = '"+username+"'";
		ResultSet resultSet = statement.executeQuery(sql);
		User user = new User();
		while (resultSet.next()) {
			user.setId(resultSet.getInt(1));
			user.setUsername(resultSet.getString(2));
			user.setPassword(resultSet.getString(3));
			user.setGender(resultSet.getString(4));
			user.setAge(resultSet.getInt(5));
			user.setHobby(resultSet.getString(6));
			user.setCity(resultSet.getString(7));
			user.setMotto(resultSet.getString(8));
		}
		return user;
	}

}
