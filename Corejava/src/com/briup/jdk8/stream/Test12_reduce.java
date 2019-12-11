package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test12_reduce {
	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 10);
		 //求1~10之间的数字累加
		//1.拿到种子0  和第一个元素操作，结果再和第二、三...操作 得出结果
		Integer sum1 = stream.reduce(0, (a,b)->a+b); 
		//或
		//Integer sum2 = stream.reduce(0, Integer::sum);
		
		System.out.println(sum1);
		
		//2.求最小值
		IntStream stream2 = IntStream.rangeClosed(1, 10);
		OptionalInt min = stream2.reduce((a,b)->a<b?a:b);
		System.out.println(min);

		//3.拼接返回字符串
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
		System.out.println(concat);
		
		//Optional<T> reduce(BinaryOperator<T> accumulator);
		//4.拼接返回 Optional
		Optional<String> opStr = Stream.of("A", "B", "C", "D").reduce(String::concat);
		System.out.println(opStr);
		
		//综合测试
		List<String> list = Arrays.asList("test","javap","hello","world","java","tom","C","javascript");
		//
		Optional<String> reduce = list.stream()
				.sorted((s1,s2)->s2.length()-s1.length())	//先按照长度 逆序
				.filter(s->s.startsWith("j"))				//筛选j开头的
				.map(s->s+"_briup")							//都加上_briup后缀
				.reduce((s1,s2)->s1+"|"+s2);				
		System.out.println(reduce);
	}
}
