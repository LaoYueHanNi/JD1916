package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a","z","c");
		
		Collections.sort(list);
		System.out.println(list);
		
		Comparator<String> c = (String o1, String o2) -> {return -o1.compareTo(o2);};
		
		Collections.sort(list, c);
		System.out.println(list);
	}
}
