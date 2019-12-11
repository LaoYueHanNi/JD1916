package com.briup.reflect;

public class Dog {
	private String name;
	private int age;
	public Dog() {
		
	}
	public Dog(String name, int age) {
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
	
	public int print(int a,int b) {
		System.out.println("·Ç¾²Ì¬");
		return a+b;
	}
	public static void printTest() {
		System.out.println("¾²Ì¬");
	}
	public void print(Object object) {
		// TODO Auto-generated method stub
		
	}
}
