package com.briup.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
	public static void filter(List<String> list, Predicate<String> condition) {  
		for(String name: list) {  
			if(condition.test(name)) {  
				System.out.println(name);  
			}  
		}  
	}  
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "html5","JavaScript", "C++", "hibernate", "PHP");
		//全都显示
		filter(list, name->true);
		System.out.println("--------------------");
		//全都不显示
		filter(list, name->false);
		System.out.println("--------------------");
		//开头是J的语言
		filter(list,name->name.startsWith("J"));
		System.out.println("--------------------");
		//5结尾的
		filter(list,name->name.endsWith("5"));
		System.out.println("--------------------");
		//显示名字长度大于4
		filter(list,name->name.length()>4);
		System.out.println("--------------------");

		//名字以J开头并且长度大于4的
		Predicate<String> c1 = name->name.startsWith("J");
		Predicate<String> c2 = name->name.length()>4;
		filter(list,c1.and(c2));
		System.out.println("--------------------");
		
		//名字不是以J开头
		Predicate<String> c3 = (name)->name.startsWith("J");
		filter(list,c3.negate());
		System.out.println("--------------------");
		
		//名字以J开头或者长度小于4的
		Predicate<String> c4 = name->name.startsWith("J");
		Predicate<String> c5 = name->name.length()<4;
		filter(list,c4.or(c5));
		System.out.println("--------------------");
		//也可以直接使用Predicate接口中的静态方法
		//名字为Java的
		filter(list,Predicate.isEqual("Java"));
		System.out.println("--------------------");
		//判断俩个字符串是否相等
		boolean test = Predicate.isEqual("hello").test("world");
		System.out.println(test);
	}
}
