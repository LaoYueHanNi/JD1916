package com.briup.dao;

import com.briup.bean.Teacher;
//Dao��Ľӿ�
public interface ITeacherDao {
	//�����û�����ѯTeacher����Ϣ
	public Teacher findTeacherByName(
			String name)throws Exception;
	
	//���Teacher����
	public void addTeacher(Teacher t)
			throws Exception;
	
}
