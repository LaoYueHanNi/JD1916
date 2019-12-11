package com.briup.generic;
import java.util.*;
public class ListTest {
	public static void main(String[] args) {
		// 泛型：限定list只能放integer的数据
		List<Integer> list =new ArrayList<Integer>();
		list.add(10);
		list.add(100);
		list.add(12);
		//list.add(false);
		int sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i);
		}
		System.out.println(sum);
		}

	 
}

