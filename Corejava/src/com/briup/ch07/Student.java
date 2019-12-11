package com.briup.ch07;

public class Student implements Comparable{
	private String name;
	private int age;
	private String gender;
	public Student() {
		
	}
	public Student(String name, int age, String gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int hashCOde() {
		//����Ӱ���ж����������Ƿ���ȵ����Ե�hashCodeֵ���
		return name.hashCode()+age+gender.hashCode();
	}
	
	
	public boolean equals(Object ob) {
		if(ob==null)return false;
		if(ob==this)return true;
		if(this.getClass()!=ob.getClass()) return false;
		Student s=(Student) ob;
		if(name.equals(s.getName())&&this.age==s.getAge()&&this.gender.equals(s.getGender())) return true;
		return false;
		
	}
	//��дtoString����
	@Override
	public String toString() {
		return name+"-"+age+"-"+gender;
	}
	@Override
	public int compareTo(Object o) {
		//ָ���������
		Student s=(Student) o;
		return this.name.compareTo(s.getName());
		//return age-s.getAge();//����������������
		//return s.getAge()-age;�������併�����С�
	}
}
