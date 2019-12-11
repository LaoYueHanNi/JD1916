package com.briup.ch06;

 //提供一个子类,根据年龄去比较
class AgeComparator extends Comparator{
	public int compare(Student s1,Student s2) {
		return s1.getAge()-s2.getAge();
	}
}

public class TeamTest extends Team{
	public static void main(String[] args) {
		Team t = new Team(4);
		
		Student s1 = new Student("tom", 19, true, 89);
		Student s2 = new Student("lili", 27, false, 81);
		Student s3 = new Student("hah", 23, true, 70);
		Student s4 = new Student("ou", 19, true, 50);
		t.addStudent(s1);
		t.addStudent(s2);
		t.addStudent(s3);
		t.addStudent(s4);
		t.display();
		
		//找最大或者最小
		Comparator c=new AgeComparator();
		Student s=t.getMaxOrMin(c);
		System.out.println(s.getAge());
	}


}
