package com.briup.enums;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		boolean a=true;
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		BigDataClass[] bdc=BigDataClass.values();
		for(BigDataClass temp:bdc) {
			//System.out.println(temp.toString());
			if(temp.toString().equals(s)){ 
				System.out.println("��ѡ����ѧ��:"+temp.getLevel()+"ѧ��Ϊ"+temp.getMoney());
				a=false;
				break;
			}
		}
		if(a) {
			System.out.println("�������");
		}
	}
}

