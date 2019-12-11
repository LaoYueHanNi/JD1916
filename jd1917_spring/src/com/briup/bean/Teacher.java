package com.briup.bean;

public class Teacher {
	private Integer id;
	private String name;
	private String gender;
	private int age;
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	public Teacher(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
}
