package com.briup.ch06;
//���Է��ʿ��Ʒ�
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
		//t.age=10;���ܷ���    
		t.name="tom";
		t.num=2;
	}
}