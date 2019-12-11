package com.briup.ch06;

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
	@Override
	public boolean equals(Object ob1) {
		if(this==ob1) return true;//判断是否是同一对象
		if(ob1==null) return false;//判断目标是否为空
		if(this.getClass()!=ob1.getClass()) return false;//判断类型是否相同
		//自定义比较规则
		if(ob1 instanceof Student) {
			Student s1=(Student)ob1;
			if(getName().equals(s1.getName())&&getAge()==s1.getAge()&&isMale()==(s1.isMale())) {
				return true;
			}
		}
		return false;	
	}
	
}
