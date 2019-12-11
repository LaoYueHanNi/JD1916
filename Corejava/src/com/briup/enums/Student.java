package com.briup.enums;

public class Student {
	enum Score{
		A,B,C,D,E;
	}
	private Gender gender;
	private Score score;
	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public static void main(String[] args) {
		Student stu=new Student();
		stu.setGender(Gender.female);
		stu.setScore(Score.A);
		System.out.println(stu.gender);
		
	}
}
