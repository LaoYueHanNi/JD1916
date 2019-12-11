package com.briup.bean;

public class Wife {
	@Override
	public String toString() {
		return "Wife [name=" + name + ", age=" + age + ", id=" + id + ", husband=" + husband + "]";
	}

	private String name;
	private int age;
	private int id;
	private Husband husband;

	public Wife() {
	}

	public Wife(String name, int age ) {
		super();
		this.name = name;
		this.age = age;
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}
}
