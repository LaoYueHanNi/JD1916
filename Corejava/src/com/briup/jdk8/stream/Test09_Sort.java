package com.briup.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/*
 * sorted
 * sorted(比较器)
 */
public class Test09_Sort {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test","hello","world","java","tom","C","javascript");
		
		//1.无参sorted() 默认排序 字典排序
		list.stream().filter(s->s.startsWith("j"))//过滤出来
		             .sorted()
		             .forEach(System.out::println);
		System.out.println("***********");
		
		//2.有参sorted(Comparator<? super T> comparator) 
		//按照字符串的长短排序
		list.stream()
		    .sorted((s1,s2)->s1.length()-s2.length())
		    .forEach(System.out::println);
		
		List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
		list2.stream().sorted((o1,o2)->{
			//两个数都是 偶数
			if(o1%2 == 0 && o2%2 == 0) {
				return o1-o2; //顺序
			}else if(o1%2 != 0 && o2%2 != 0) { //都是奇数
				return o2-o1; //逆序
			}else if(o1%2 == 0 && o2%2 != 0) {	//第一个偶数 第二个奇数
				return 1;	//偶数更大  放在后面
			}else {	//第一个奇数 第二个偶数
				return -1;	//奇数小  放在前面
			}
		}).forEach(System.out::println);

	}
}







