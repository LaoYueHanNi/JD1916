package com.briup.aop.moni.dynamicProxy;

import com.briup.db.bean.Student;

public class StudentIServiceImpl implements IStudentService{

	@Override
	public void save(Student s) {
		System.out.println("Ŀ����save");
	}

	@Override
	public void delete(long id) {
		System.out.println("Ŀ����delete");
	}

	@Override
	public Student find(long id) {
		System.out.println("Ŀ����find");
		return null;
	}

}
