package com.briup.mappers;
import java.util.List;
import com.briup.bean.Student;
	//ӳ��ӿڣ���Ҫ��ӳ���ļ���������
		//��ִ��ӳ���ļ���sql���
public interface StudentMapper {
	public List<Student> findAllStudents();
	public Student findStudentById(int id);
	public void	insertStudent(Student stu);
	
	public void updateStudentById(Student stu);
	public void deleteStudentById(int id);
	public void deleteAllStudents();
	public void insertStudentAndPhone(Student student);
}
