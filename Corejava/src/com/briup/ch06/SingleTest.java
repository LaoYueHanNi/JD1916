package com.briup.ch06;
//����ģʽ
class Single{
	private static Single s1;
	static {//����ʽ
		if(s1==null) {
			s1=new Single();
		}
	}
	private Single() {	
		
	}
	public static Single getSingle() {
		/*����ʽ
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
