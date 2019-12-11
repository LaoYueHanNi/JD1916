package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * collect 收集起来【获得一个集合】
 * 
 */
public class Test16_collect {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello","abc","world","nihao","max","min");
		
		/* 在Stream里面的collect方法原型为:
		 * <R, A> R collect(Collector<? super T, A, R> collector);
		 * 
		 * 在Collectors中的静态函数toList原型:
		 * public static <T>
    			Collector<T, ?, List<T>> toList() { ... }
		 * 返回的对象 正好 可以放到collect函数中!!!
		 */
		List<String> list2 = list.stream()
			.filter(s->s.length()>3)
			.collect(Collectors.toList());
		
		System.out.println(list2);
		
	}
}
