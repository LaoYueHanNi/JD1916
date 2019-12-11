package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/*
 * limit 值保留前几个
 * skip 跳过前几个 
 */
public class Test12_Limit {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("test","javap","hello","world","java","tom","C","javascript");
		//list.stream().limit(5).forEach(System.out::println);
		list.stream().skip(5).forEach(System.out::println);
		
	}
}
