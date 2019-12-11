package com.briup.mappers;

import java.util.List;

import com.birup.bean.Group;
import com.birup.bean.User;

public interface GroupAndUserMapper {
	public void insertGroup(Group group);
	public void insertUser(User user);
	public List<Group> findGroupWithUser();
}
