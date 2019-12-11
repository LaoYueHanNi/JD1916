package Myself;

import java.util.*;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet=new TreeSet<>();
		treeSet.add(1);
		treeSet.add(1);
		treeSet.add(3);
		treeSet.add(2);
		treeSet.add(9);
		treeSet.add(5);
		for(int i:treeSet) {
			System.out.println(i);
		}
	}
}
