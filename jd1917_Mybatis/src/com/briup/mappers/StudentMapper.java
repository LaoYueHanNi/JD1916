package com.briup.mappers;
import java.util.List;
import com.briup.bean.Student;
	//映射接口：需要和映射文件关联起来
		//会执行映射文件的sql语句
public interface StudentMapper {
	public List<Student> findAllStudents();
	public Student findStudentById(int id);
	public void	insertStudent(Student stu);
	
	public void updateStudentById(Student stu);
	public void deleteStudentById(int id);
	public void deleteAllStudents();
	public void insertStudentAndPhone(Student student);
}
