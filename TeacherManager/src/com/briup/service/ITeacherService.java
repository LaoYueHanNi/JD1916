package com.briup.service;

import com.briup.bean.Teacher;
import com.briup.exception.TeacherException;

//����Service�ı�׼
public interface ITeacherService {
	//ע��
	public void register(Teacher t) 
			throws TeacherException;
	//��¼
	public Teacher login(String name,
					String pwd)
			throws TeacherException;
	//ת��
	
	//���Ϲ���
}
