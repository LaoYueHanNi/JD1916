package com.briup.ch06;
//测试访问控制符
public class AccessTest {
	private int age;
	String name;
	protected int num;
	public int count;
	public void print() {
		age=0;	
	}
}
class Atest{
	public void print () {
		AccessTest t=new AccessTest();
		//t.age=10;不能访问    
		t.name="tom";
		t.num=2;
	}
}