package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/*
 * anyMatch allMatch noneMatch
 */
public class Test10_match {
	public static void main(String[] args) {
		//1.allMatch �Ƿ�ȫ��ƥ��
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		boolean allMatch = list.stream().allMatch((s)->s.startsWith("j"));
		System.out.println(allMatch);

		//2.anyMatch ����һ��ƥ��ɹ��ͷ���true ���򷵻�false
		List<String> list2 = Arrays.asList("test","hello","world","java","tom","C","javascript");
		boolean anyMatch = list2.stream().anyMatch((s)->s.startsWith("j"));
		System.out.println(anyMatch);

		//3.noneMatch û��һ��ƥ��ľͷ���true ���򷵻�false
		List<String> list3 = Arrays.asList("test","hello","world","java","tom","C","javascript");
		boolean noneMatch = list3.stream().noneMatch((s)->s.startsWith("j"));
		System.out.println(noneMatch);
	}
}
