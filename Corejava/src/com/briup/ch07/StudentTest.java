package com.briup.ch07;

import java.util.*;

public class StudentTest {
	public static void main(String[] args) {
		Student s1=new Student("tom",22,"male");
		Student s2=new Student("lili",23,"female");
		Student s3=new Student("mike",21,"male");
		Student s4=new Student("tom",25,"male");
		
		Set  set =new HashSet();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		System.out.println(set.size());
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
	}
}
