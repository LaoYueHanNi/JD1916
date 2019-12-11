package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/*
 * anyMatch allMatch noneMatch
 */
public class Test10_match {
	public static void main(String[] args) {
		//1.allMatch 是否全部匹配
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		boolean allMatch = list.stream().allMatch((s)->s.startsWith("j"));
		System.out.println(allMatch);

		//2.anyMatch 任意一个匹配成功就返回true 否则返回false
		List<String> list2 = Arrays.asList("test","hello","world","java","tom","C","javascript");
		boolean anyMatch = list2.stream().anyMatch((s)->s.startsWith("j"));
		System.out.println(anyMatch);

		//3.noneMatch 没有一个匹配的就返回true 否则返回false
		List<String> list3 = Arrays.asList("test","hello","world","java","tom","C","javascript");
		boolean noneMatch = list3.stream().noneMatch((s)->s.startsWith("j"));
		System.out.println(noneMatch);
	}
}
