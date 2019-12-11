package com.briup.mappers;

import java.util.List;

import com.briup.bean.Address;
import com.briup.bean.Student;

public interface One2OneMapper {
	public Student findStuByIdWithAddress(int id ) ;
	public List<Student> findStuWithAddress();
	public List<Student> ListStusWIthAddress();
	public void insertAddress(Address address);
	public void insertStudent(Student student);
}
