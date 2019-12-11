package Myself;

import java.util.*;

public class TreeSetTecher {
	public static void main(String[] args) {
		TreeSet<TeacherTreeSetTest> treeSet=new TreeSet<TeacherTreeSetTest>();
		treeSet.add(new TeacherTreeSetTest("peterr",25));
		treeSet.add(new TeacherTreeSetTest("tom",27));
		treeSet.add(new TeacherTreeSetTest("tony",25));
		treeSet.add(new TeacherTreeSetTest("ouyang",22));
		treeSet.add(new TeacherTreeSetTest("ouyang",21));
		for(TeacherTreeSetTest t:treeSet) {
			System.out.println(t.getName()+"----"+t.getAge());
		}
	}
}
