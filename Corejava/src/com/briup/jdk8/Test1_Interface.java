package com.briup.jdk8;

import com.briup.thread.FourThread;

//²âÊÔ½Ó¿Ú
interface Formula{
	public static final int num=10;
	int age=20;
	public void cal();
	public default double sqrt(int n) {
		return Math.sqrt(n);
	}
	public static void sayHello() {
		System.out.println("hello");
	}
}
class T implements Formula{

	@Override
	public void cal() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Test1_Interface {
	public static void main(String[] args) {
		Formula.sayHello();
		Formula f=new T();
		f.sqrt(44);
		Formula f1=new Formula() {
			
			@Override
			public void cal() {
				// TODO Auto-generated method stub
				
			}
		};
		System.out.println(f1.sqrt(44));
		f1.cal();  
	}
}
