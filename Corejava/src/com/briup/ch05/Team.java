package com.briup.ch05;
//管理学生团队信息
public class Team {
	private String name;
	private Address address;
	private Student[] team;
	private int size=0;//当前人数
	private  int length;//团队最多的容量人数
	
	public Team() {  		
	}
	public Team(int length) {
		team=new Student[length];
		this.length=length;
	}
	
	
	public void addStudent(Student stu) {
		if(stu==null) {
			System.out.println("不能加入空对象");
			return;
		}
		if(size>=length) {
			System.out.println("团队满了，不能加入");
			return;
		}
		if(findStudent(stu)!=-1) {
			System.out.println("该学生已经在团队中");
			return;
		}
		//加入学生到团队
		team[size]=stu;
		size++;
	}
	
	public void removeStudent(Student stu) {
		if(size<=0) {
			System.out.println("没人，不能删");
			return;
		}
		int index=findStudent(stu);
		if(index==-1) {
			System.out.println("该学生不在团队中");
			return;
		}
		//删除
		for(int i=index;i<size-1;i++) {
			team[i]=team[i+1];
		}
		team[--size]=null;
	}
	//如果不在团队中，返回-1
	public int findStudent(Student stu) {
		int index=-1;
		for(int i=0;i<=team.length-1;i++) {
			if(stu==team[i]) {
				index=i;
				break;
			}
		}		
		return index;
	}
	
	public void display() {
		for(int i=0;i<size-1;i++) {
			System.out.println(team[i].getAge());
		}
	}
}