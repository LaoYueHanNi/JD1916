package com.briup.db.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.briup.db.bean.Student;
import com.briup.db.mybatisDao.IStudentDao;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
@Component
public class StudentServiceImplByMybatis implements IStudentService{
	 
	private IStudentDao stuDao;
	public void setstuDao(IStudentDao stuDao) {
		this.stuDao=stuDao;
	}
	@Override
	public void saveStudent(Student stu) {
		stuDao.addStudent(stu);
	}

}
