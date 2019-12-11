package com.briup.ch05;

public class TeamTest extends Team{
	public static void main(String[] args) {
		Team t = new Team(5);
		
		Student s1 = new Student("tom", 20, true, 89);
		Student s2 = new Student("lili", 20, false, 89);
		Student s3 = new Student("hah", 20, true, 70);
		Student s4 = new Student("ou", 19, true, 50);
		t.addStudent(s1);
		t.addStudent(s2);
		t.addStudent(s3);
		t.display();
	}


}
