package laoYueHan;

import java.util.Scanner;

public class N3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("������̨�ײ���:");
		int step=sc.nextInt();
		
		if(step==1) {
			System.out.println("һ��̨����һ���߷�");
		}
		if(step==2) {
			System.out.println("һ��̨���������߷�");
		}
		if(step==3) {
			System.out.println("һ��̨���������߷�");
		}
		if(step>3){
			System.out.println(step+"��̨��,����ֻ����һ��,������������,��"+steps(step)+"���߷�");
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
