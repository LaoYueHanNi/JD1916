package Work;

import com.briup.ch05.Test;

public class TestEquals {
	/*
	 * private int a; private int b;
	 */
	private String name;
	public TestEquals(String name) {
		/*
		 * this.a=a; this.b=b;
		 */
		this.name=name;
	}
	@Override
	public boolean equals(Object obj) {
		TestEquals t1=(TestEquals)obj;
		return this.name==t1.name;
	}
	
	public static void main(String[] args) {
		int c=10;
		int d=10;
//		TestEquals t1=new TestEquals(2, 3);
//		TestEquals t2=new TestEquals(2,3);
//		System.out.println(t1==t2);
//		System.out.println(t1.equals(t2));
		System.out.println(c==d);
		TestEquals t1=new TestEquals("tom");
		TestEquals t2=new TestEquals("Mike");
		TestEquals t3=new TestEquals("Mike");
		System.out.println(t2==t3);
		System.out.println(t2.equals(t3));
		System.out.println(t1.toString());
		
	}
	@Override
	public String toString() {
		return "TestEquals [name=" + name + "]";
	}
}
