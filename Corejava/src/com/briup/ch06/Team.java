package com.briup.ch06;

//����ѧ���Ŷ���Ϣ
public class Team {
	private String name;

	private Student[] team;
	private int size = 0;// ��ǰ����
	private int length;// �Ŷ�������������

	public Team() {
	}

	public Team(int length) {
		team = new Student[length];
		this.length = length;
	}

	public void addStudent(Student stu) {
		if (stu == null) {
			System.out.println("���ܼ���ն���");
			return;
		}
		if (size >= length) {
			System.out.println("�Ŷ����ˣ����ܼ���");
			return;
		}
		if (findStudent(stu) != -1) {
			System.out.println("��ѧ���Ѿ����Ŷ���");
			return;
		}
		// ����ѧ�����Ŷ�
		team[size] = stu;
		size++;
	}

	public void removeStudent(Student stu) {
		if (size <= 0) {
			System.out.println("û�ˣ�����ɾ");
			return;
		}
		int index = findStudent(stu);
		if (index == -1) {
			System.out.println("��ѧ�������Ŷ���");
			return;
		}
		// ɾ��
		for (int i = index; i < size - 1; i++) {
			team[i] = team[i + 1];
		}
		team[--size] = null;
	}

	// ��������Ŷ��У�����-1
	public int findStudent(Student stu) {
		int index = -1;
		for (int i = 0; i <= team.length - 1; i++) {
			if (stu == team[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void display() {
		for (int i = 0; i < size - 1; i++) {
			System.out.println(team[i].getAge());
		}
	}

	// �����ҵ��Ŷ�����������С��ѧ��
	public   Student getMaxOrMin(Comparator c) {
		if (size <= 0) {
			System.out.println(" ��ǰ�Ŷ�û��");
			return null;
		}
		Student stu = team[0];
		for (int i = 1; i < size; i++) {
			if (c.compare(stu, team[i]) > 0) {
				stu=team[i];
			}	
		}
		return stu;
	}

}