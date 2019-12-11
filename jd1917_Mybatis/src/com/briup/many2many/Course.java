package com.briup.many2many;

import java.util.List;


public class Course {
	private Integer id;
	private String courseCode; // �γ̱��
	private String courseName;// �γ�����
	private List<Student> students;// ѡ��ѧ��
	
	public Course(){}
	
	public Course(Integer id, String courseCode, String courseName) {
		super();
		this.id = id;
		this.courseCode = courseCode;
		this.courseName = courseName;
	}
	public Course(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseCode=" + courseCode
				+ ", courseName=" + courseName + ", students=" + students + "]";
	}
}
