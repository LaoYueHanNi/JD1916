package com.briup.jdk8.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 * generate 生成海量测试数据
 */
public class Test14_generate {
	public static void main(String[] args) {
		/*
		 * public static<T> Stream<T> generate(Supplier<T> s);
		 * 	
		 * public interface Supplier<T> {  //供应商
		 * 	  T get();
		 * }
		 */
		
		//生成5个 [0,30) 随机数，然后输出
		Stream.generate(()->new Random().nextInt(30))
			.limit(5)
			.forEach(System.out::println);
		
	}
}
