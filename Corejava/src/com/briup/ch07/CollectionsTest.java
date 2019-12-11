package com.briup.ch07;
import java.util.*;
public class CollectionsTest {
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<>();
		list.add(30);
		list.add(47);
		list.add(100);
		list.add(2);
		list.add(31);
		Collections.sort(list);//自然排序
		//二分查找
		int index=Collections.binarySearch(list, 30);//二分查找
		System.out.println(index);
		Collections.shuffle(list);//洗牌随机打乱
		System.out.println(list);
	}
}
