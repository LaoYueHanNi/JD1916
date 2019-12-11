package laoYueHan;

import java.util.Scanner;

public class N3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入台阶步数:");
		int step=sc.nextInt();
		
		if(step==1) {
			System.out.println("一个台阶有一种走法");
		}
		if(step==2) {
			System.out.println("一个台阶有两种走法");
		}
		if(step==3) {
			System.out.println("一个台阶有三种走法");
		}
		if(step>3){
			System.out.println(step+"层台阶,限制只能走一步,两步或者三步,有"+steps(step)+"种走法");
		}
	}
	public static int steps(int num) {
		int result=0;
		int f1=1;
		int f2=2;
		int f3=4;
		for(int i=4;i<=num;i++) {
			result=f1+f2+f3;
			f1=f2;
			f2=f3;
			f3=result;
		}
		return result;
	}
}
