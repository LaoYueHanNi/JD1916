package com.briup.ch07;
import java.util.*;
public class MapTest {
	public static void main(String[] args) {
		Map map=//new HashMap();
		//new Hashtable();
		new TreeMap();
		map.put(1,"hello");
		map.put(2,"xixi");
		map.put(3, "VV");
		map.put(1, "WW");
		map.remove(1);
		System.out.println(map.size());
		System.out.println(map);
		
		//遍历map
		out1(map);      
		out2(map);      
		out3(map);      
	}

	private static void out1(Map map) {
		//使用keyset()遍历
		Set keys=map.keySet();
		for(Object key:keys) {
			Object value=map.get(key);
			System.out.println(key+" "+value);
		}
	}
	private static void out2(Map map) {
		// 使用entrySet()遍历
		Set set =map.entrySet();
		Iterator iter=set.iterator();
		while(iter.hasNext()) {
				Object obj=iter.next();
				Map.Entry entry=(Map.Entry)obj;
				Object key=entry.getKey();
				Object value=entry.getValue();
				System.out.println(key+" "+ value);
			}
		}
	private static void out3(Map map) {
		//使用values()方法遍历，只能找value，不能找key
		Collection coll=map.values();
//		for(Object temp:coll) {
//			System.out.println(temp);
//		}
		Iterator iter =coll.iterator();
		while(iter.hasNext()) {
			Object obj=iter.next();
			System.out.println(obj);
		}
	}
}
