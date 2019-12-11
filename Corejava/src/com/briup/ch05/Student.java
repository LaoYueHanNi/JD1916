package com.briup.ch05;

public class Student {
	private String name;
	private int age;
	private boolean male;
	private int grade;
	public Student(String name, int age, boolean male, int grade) {
		super();
		this.name = name;
		this.age = age;
		this.male = male;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
