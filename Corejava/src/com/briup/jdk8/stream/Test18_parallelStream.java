package com.briup.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * 并行stream测试
 */
public class Test18_parallelStream {
	public static void main(String[] args) {
		
		//生成100万个不同的字符串放到集合中
		int max = 1000000;
		List<String> list = new ArrayList<String>(max);
		for (int i = 0; i < max; i++) {
			//用来 生成随机数
		    UUID uuid = UUID.randomUUID();
		    list.add(uuid.toString());
		}


		//1纳秒*10^9=1秒 
		long t0 = System.nanoTime();
		//串行stream 
		//long count = list.stream().sorted().count();
		//并行stream
		long count = list.parallelStream().sorted().count();
		long t1 = System.nanoTime();

		long time = t1 - t0;
		System.out.println(count);
		System.out.println(time);
	}
	
}
