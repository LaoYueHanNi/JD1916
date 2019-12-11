package com.briup.ch06;
import static java.lang.Math.*;
//测试static关键字
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
	private static int count;// 静态变量
	private int num;//非静态变量
	
	//普通初始化块
	{
		System.out.println("xixixhah");
	}
	//静态初始化块
	static{
		System.out.println("hahxixi");
	}
	public StaticTest() {
		num++;
		count++;
	}
	public static void main(String[] args) {
		random();// 导入的时候加了static可以不用类名调用，不加的话是Math.random()
		
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
		//static不能修饰局部变量
	}
	public static void display() {
		//静态方法无法访问非静态的变量
		//num=10;报错
		count=10;
	}
}
