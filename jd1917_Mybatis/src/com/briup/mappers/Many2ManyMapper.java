package com.briup.mappers;

import java.util.List;

import com.briup.many2many.Course;
import com.briup.many2many.Student;

public interface Many2ManyMapper {
	//����student����
	public void insertStudent(Student student);
	//����course����
	public void insertCourse(Course course);
	//ͨ��id��ѯѧ��
	public Student getStudentById(Integer id);
	//ͨ��id��ѯ�γ�
	public Course getCourseById(Integer id);
	
	//ѧ��xѡ��y
	public void studentSelectCourse(Student student, Course course);
	
	//��ѯ��ָ��idֵС��ѧ����Ϣ
	public List<Student> getStudentByIdOnCondition(Integer id);
	
	//��ѯstudent������ѯ����ѡ��course������װ�������Ķ���
	public Student getStudentByIdWithCourses(Integer id);
	
	public void deleteStudent(int id);
	public void deleteTableMsg(int id);
	
	public List<Course> getAllCoursesWithStudent();

}
