package Work;
//键盘录入一个学生成绩，如果成绩属于[0,100],输出成绩，

//否则，抛出异常，并提示成绩必须在[0,100]内

import java.util.Scanner;

public class Work9_24_2 {
	public static void main(String[] args) throws Exception {
		System.out.println("输入一个学生成绩,应在0到100之间");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a>=0&&a<=100) {
			System.out.println("成绩为:"+a);
		}
		else {
			throw new Exception("成绩必须在[0,100]");
		}
		
		
	}
}
