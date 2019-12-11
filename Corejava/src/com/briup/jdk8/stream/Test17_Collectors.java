package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test17_Collectors {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		
		/* 在Stream内部的collect函数原型: 
		 * <R, A> R collect(Collector<? super T, A, R> collector);
		 * 
		 * Collectors中静态方法groupingBy的原型: 
		 * public static <T, K> Collector<T, ?, Map<K, List<T>>>
    			groupingBy(Function<? super T, ? extends K> classifier){ ... }
    			
    	 * 故而，groupingBy中传参s->s.length()即可,实现Function接口
		 */
		//相同长度的字符串放到一个List集合中作为Map的value,字符串的长度作为Map的Key
		Map<Integer, List<String>> collect1 = list.stream()
				.collect(Collectors.groupingBy(String::length));
		
		//或者
		Map<Integer, List<String>> collect2 
				= list.stream()
				  .collect(Collectors.groupingBy(s->s.length()));
	
		//输出map中的key和value
		collect1.forEach((k,v)->{
			System.out.println(k+" : "+v);
		});
		
		System.out.println("******************");
		collect2.forEach((k,v)->{
			System.out.println(k+" : "+v);
		});
	}
}
