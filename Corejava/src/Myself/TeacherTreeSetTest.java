package Myself;

public class TeacherTreeSetTest implements Comparable<TeacherTreeSetTest> {
	private int age;
	private String name;

	public TeacherTreeSetTest(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Teacher name="+name+",age="+age+"]";
	}

	@Override
	public int compareTo(TeacherTreeSetTest t) {
		//return -1;��ʾ�������
		//return 1;��ʾ�������
		//return 0;��ʾ������ͬ,�����һ��Ԫ��
		int num=this.name.length()-t.name.length();
		int num1=num==0?this.name.compareTo(t.name):num;
		int num2=num1==0?this.age-t.age:num1;
		return num2;
	}

	

}
