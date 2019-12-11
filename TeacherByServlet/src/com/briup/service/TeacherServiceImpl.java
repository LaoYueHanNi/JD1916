package com.briup.service;

import com.briup.bean.Teacher;
import com.briup.dao.ITeacherDao;
import com.briup.dao.TeacherDaoImpl;
import com.briup.exception.TeacherException;

//Service���ʵ����
public class TeacherServiceImpl 
			implements ITeacherService{
	
	private ITeacherDao dao;
	public TeacherServiceImpl() {
		dao=new TeacherDaoImpl();
	}
	@Override
	public void register(Teacher t) throws TeacherException {
		try {
			Teacher t1=dao.findTeacherByName
						(t.getName());
			if(t1.getName()!=null) {
				throw new Exception(
					"�û����Ѿ���ռ��,������ע��!");
			}
			dao.addTeacher(t);//�����ʦ
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeacherException(
							e.getMessage());
		}
	}
	@Override
	public Teacher login(String name,
			String pwd) throws TeacherException {
		Teacher t  = null;
		try {
			t=dao.findTeacherByName(name);
			if(t.getName()==null){
				throw new Exception("�û���������!");
			}else if(!t.getPwd().equals(pwd)) {
				throw new Exception("�����������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeacherException(e.getMessage());
		}
		return t;
	}

}
