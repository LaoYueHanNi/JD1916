package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/*
 * filter����
 * 
 */
public class Test06_Filter {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		list.stream()
		    .filter(s->s.indexOf("java") != -1)//���ذ���java�������±�
		    .forEach(System.out::println);
	}
}





