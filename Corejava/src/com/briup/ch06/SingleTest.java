package com.briup.ch06;
//单例模式
class Single{
	private static Single s1;
	static {//饿汉式
		if(s1==null) {
			s1=new Single();
		}
	}
	private Single() {	
		
	}
	public static Single getSingle() {
		/*懒汉式
		 * if(s1==null) { s1=new Single(); }
		 */
		return s1;
		
	}
}

public class SingleTest {
	public static void main(String[] args) {
		Single s1=Single.getSingle();
		Single s2=Single.getSingle();
		System.out.println(s1);
		System.out.println(s2);
	}
}
