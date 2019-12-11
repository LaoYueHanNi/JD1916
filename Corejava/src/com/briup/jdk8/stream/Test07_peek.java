package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * peek 对每个元素执行操作
 * 	Stream peek(Consumer c);
 */
public class Test07_peek {
	public static void main(String[] args) {
		
		//注意 peek后面一定要有  最终操作，否则peek不执行
		List<String> list = Arrays.asList("one", "two", "three", "four");
		List<String> list2 = list.stream()
						 .filter(e -> e.length() > 3)//过滤元素 
						 .peek(e->System.out.println("符合条件的值为: " + e))
						 .collect(Collectors.toList());
		//打印结果为 2
		System.out.println(list2.size());
	}
}
