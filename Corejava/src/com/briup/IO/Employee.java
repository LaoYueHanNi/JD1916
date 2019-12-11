package com.briup.IO;

import java.io.Serializable;

public class Employee implements Serializable{
	
	/**
	 * 
	 */
	//��ʾָ��uid��ֵ
	private static final long serialVersionUID = -4703958187123597069L;
	private String name;
	private int age;
	private String gender;
	//transient��ʶ�����Բ������л�(͸����)
	private  transient double salary;
	public Employee(){ }
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}
