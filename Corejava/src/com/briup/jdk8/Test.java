package com.briup.jdk8;
//测试JDK自带的一些函数式接口
import java.util.function.*;
public class Test {
	public static void main(String[] args) {
		//Predicate断定为
		Predicate<String> p1=new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				return t.startsWith("j");
			}
		};
		boolean b=p1.test("corejava");
		System.out.println(b);
		Predicate<String> p2=t->t.startsWith("c");;
		System.out.println(p2.test("coreJava"));
		
		Predicate<Integer> p3=t->t>30;
		//////
		Predicate<Integer> p4=t->t<50;
		Predicate<Integer> p5=p3.and(p4);//p5既要满足p3条件也要满足p4条件
		System.out.println(p5.test(50));
		
		Predicate<Integer> p6=p3.or(p4);
		System.out.println(p6.test(50));
		
		///
		Predicate<Integer> p7=p3.negate();//相反条件^
		
		
		
		//测试Supplier供应商
		Supplier<String> s1=new Supplier<String>() {
			
			@Override
			public String get() {
				// TODO Auto-generated method stub
				return "hello";
			}
		};
		s1.get();
		////
		Supplier<Student> s2=Student::new ;
		//
		Consumer<String> c1=new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				t=t+"world";
				System.out.println(t);
			}
		};
		c1.accept("hello");
		////
		Consumer<Integer> c2=t->{
			t=t*t;
			System.out.println(t);
		};
		c2.accept(39);
		Consumer<Integer> c3=t->{
			t=t*2;
			System.out.println("t="+t);
		};
		Consumer<Integer> c4=c2.andThen(c3);//先执行前一个,再执行后一个
		c4.accept(10);
		System.out.println("----");
		//Function
		Function<String, Integer> f1=t->t.length();
		Integer i=f1.apply("hello world");
		System.out.println(i);
		//////
		Function<Integer, String> f2=//t->Integer.toBinaryString(t);
									Integer::toBinaryString;
		System.out.println(f2.apply(-10));
		
		//String ----Integer-----Student
		Function<String,Integer> f3=t->Integer.parseInt(t);
		Function<Integer, Student> f4=t->new Student(t);
									//Student::new;
		Function<String,Student> f5=f3.andThen(f4);
		System.out.println(f5.apply("23"));
	}
	
}
