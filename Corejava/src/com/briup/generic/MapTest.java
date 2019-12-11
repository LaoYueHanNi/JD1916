package com.briup.generic;

import java.util.*;

import com.briup.ch07.*;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, Student> map = new HashMap<>();

		map.put(1, new Student("tom", 20, "male"));
		map.put(2, new Student("mike", 20, "male"));
		map.put(3, new Student("lili", 20, "female"));

		out1(map);
		out2(map);
		out3(map);
	}

	public static void out1(Map<Integer,Student> map) {
		Set<Integer> keys=map.keySet();
		Iterator<Integer> iter=keys.iterator();
		while(iter.hasNext()) {
			Integer key =iter.next();
			Student stu=map.get(key);
			System.out.println(key+":"+stu);
		}
		
	}

	public static void out2(Map<Integer,Student> map) {
		Set<Map.Entry<Integer, Student>> set=map.entrySet();
		Iterator<Map.Entry<Integer, Student>> iter =set.iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, Student> entry=iter.next();
			Integer key=entry.getKey();
			Student stu=entry.getValue();
			System.out.println(key+" "+stu);
		}
	}

	public static void out3(Map<Integer,Student> map) {
		
	}
}
