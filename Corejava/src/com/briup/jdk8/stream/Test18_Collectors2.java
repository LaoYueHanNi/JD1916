package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * partitioningBy 分割
 */
public class Test18_Collectors2 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		
		//将stream中的字符串 按照 是否包含java子串 进行分割，分成两部分，
		//最终存放到map集合中
		Map<Boolean, List<String>> collect = 
				list.stream().collect(Collectors.partitioningBy(s->s.indexOf("java")!=-1));
		
		for(Boolean b : collect.keySet()){
			System.out.println(b+" : "+collect.get(b).size());
		}
		
	}
}
