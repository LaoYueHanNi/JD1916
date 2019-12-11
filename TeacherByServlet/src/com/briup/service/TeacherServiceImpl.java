package com.briup.service;

import com.briup.bean.Teacher;
import com.briup.dao.ITeacherDao;
import com.briup.dao.TeacherDaoImpl;
import com.briup.exception.TeacherException;

//Service层的实现类
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
					"用户名已经被占用,请重新注册!");
			}
			dao.addTeacher(t);//添加老师
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
				throw new Exception("用户名不存在!");
			}else if(!t.getPwd().equals(pwd)) {
				throw new Exception("密码输入错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new TeacherException(e.getMessage());
		}
		return t;
	}

}
