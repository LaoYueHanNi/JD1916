package com.briup.dao;

import com.briup.bean.Teacher;
//Dao层的接口
public interface ITeacherDao {
	//根据用户名查询Teacher的信息
	public Teacher findTeacherByName(
			String name)throws Exception;
	
	//添加Teacher对象
	public void addTeacher(Teacher t)
			throws Exception;
	
}
