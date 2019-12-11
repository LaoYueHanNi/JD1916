package com.briup.db.dao;

import java.util.List;

import com.briup.db.bean.Student;

public interface IStudentDao {
	
	public List<Student> selectStudents();
	
	public Student selectStudentById(int id);
	
	public List<Student> selectStudentByName(String name);
	
	public void deleteStudentById(int id);
	
	public void addStudent(Student stu);
}
