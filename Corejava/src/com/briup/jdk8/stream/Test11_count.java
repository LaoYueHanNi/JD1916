package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class Test11_count {
	public static void main(String[] args) {
		List<String> list = 
				Arrays.asList("test","hello","world","java","tom","C","javascript");
		long count = list.stream().filter(s->s.startsWith("j")).peek(System.out::println).count();
		System.out.println(count);
	}
}
