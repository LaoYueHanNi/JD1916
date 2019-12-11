package com.birup.bean;

public class User {
	private int id;
	private String name;
	private int age;
	private int groupId;
	
	public User() {
	}

	public User(int id, String name, int age, int groupId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.groupId = groupId;
	}

	public User( String name, int age, int groupId) {
		super();
		this.name = name;
		this.age = age;
		this.groupId = groupId;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age +  "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
