package com.briup.aop.moni.dynamicProxy;

import com.briup.db.bean.Student;

public interface IStudentService {
	void save(Student s);
	
	void delete(long id);
	
	Student find(long id);
	

}
