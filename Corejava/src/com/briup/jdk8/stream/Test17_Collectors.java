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
		
		/* ��Stream�ڲ���collect����ԭ��: 
		 * <R, A> R collect(Collector<? super T, A, R> collector);
		 * 
		 * Collectors�о�̬����groupingBy��ԭ��: 
		 * public static <T, K> Collector<T, ?, Map<K, List<T>>>
    			groupingBy(Function<? super T, ? extends K> classifier){ ... }
    			
    	 * �ʶ���groupingBy�д���s->s.length()����,ʵ��Function�ӿ�
		 */
		//��ͬ���ȵ��ַ����ŵ�һ��List��������ΪMap��value,�ַ����ĳ�����ΪMap��Key
		Map<Integer, List<String>> collect1 = list.stream()
				.collect(Collectors.groupingBy(String::length));
		
		//����
		Map<Integer, List<String>> collect2 
				= list.stream()
				  .collect(Collectors.groupingBy(s->s.length()));
	
		//���map�е�key��value
		collect1.forEach((k,v)->{
			System.out.println(k+" : "+v);
		});
		
		System.out.println("******************");
		collect2.forEach((k,v)->{
			System.out.println(k+" : "+v);
		});
	}
}
