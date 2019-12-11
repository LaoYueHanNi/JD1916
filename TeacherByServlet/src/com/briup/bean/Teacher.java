package com.briup.bean;

public class Teacher {
	private Integer id;
	private String name;
	private String pwd;
	private int age;
	
	public Teacher() {}
	public Teacher(Integer id, String name, String pwd, int age) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
