package com.briup.ch06;
import static java.lang.Math.*;
//����static�ؼ���
class Parent{
	public static void test() {
		System.out.println("parent...s");
	}
}
class Son extends Parent{
	//@Override
	public static void test() {
		System.out.println("sjsjsj");
	}
}

public class StaticTest {
	private static int count;// ��̬����
	private int num;//�Ǿ�̬����
	
	//��ͨ��ʼ����
	{
		System.out.println("xixixhah");
	}
	//��̬��ʼ����
	static{
		System.out.println("hahxixi");
	}
	public StaticTest() {
		num++;
		count++;
	}
	public static void main(String[] args) {
		random();// �����ʱ�����static���Բ����������ã����ӵĻ���Math.random()
		
		Parent p=new Son();
		p.test();
		
		
		StaticTest t1=new StaticTest();
		StaticTest t2=new StaticTest();
		new StaticTest();
		t1.count=10;
		t1.num=10;
		System.out.println(t2.num);
		System.out.println(t2.count);
		display();
		t1.print();
	}
	public void print() {
		//static�������ξֲ�����
	}
	public static void display() {
		//��̬�����޷����ʷǾ�̬�ı���
		//num=10;����
		count=10;
	}
}
