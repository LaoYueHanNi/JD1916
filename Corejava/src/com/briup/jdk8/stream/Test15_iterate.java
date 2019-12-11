package com.briup.jdk8.stream;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
 * 生成等差序列
 * 	传入一个种子，利用算法 得到结果，作为第二个种子，然后相同算法
 * 	计算得到第三个种子，依次类推
 */
public class Test15_iterate {
	public static void main(String[] args) {
		
		/*									种子                         算法		
		 * static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 * 
		 * 算法
		 * interface UnaryOperator<T> extends Function<T, T> {
		 * 	  T apply(T t);	
		 * 	//int apply(int n) { return n+2; } 
		 * }
		 * 
		 */
		
		//iterate方法，类似reduce   
		//生成一个等差序列
		Stream.iterate(0, n->n+2)
			.limit(10)
			.forEach(System.out::println);
		
	}
}
