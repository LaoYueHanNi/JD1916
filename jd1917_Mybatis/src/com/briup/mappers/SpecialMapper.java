package com.briup.mappers;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.briup.bean.User;
import com.briup.bean.UserPic;

public interface SpecialMapper {
	public void insertUser(User user);

	public List<User> selectUser();

	public void insertUserPic(UserPic userPic);

	public UserPic getUserPicById(int id);

	public List<User> findAllUsers();

	public List<User> findAllUsers(RowBounds rowBounds);

	public List<User> findUserByRow(int end, int start);

	public User findUserById(int id);
}
