package Myself;

import java.util.Scanner;

public class WorkZ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个正整数");
		int n = sc.nextInt();
		System.out.print(n+"=");
		String s="";
		for(int k=2;k<=n;k++) {
			if(n%k==0) {
				System.out.print(s+k);
				n=n/k;
				k=2;
				s="*";
			}
		}
//		a(n);
	}

//	public static int a(int n) {
//		if (n <= 2) {
//			System.out.println(n);
//		} else {
//			String s = "";
//			System.out.print(n + "=");
//			int c = n;
//			int d=0;
//			for (int i = 2; i <= c; i++) {
//				if (n % i == 0) {
//					System.out.print(s + i);// 2*3*5
//					n = n / i;// 45 15 3
//					s = "*";
//				}
//				if (n < i&&d==0) {
//					System.out.print(s+n);
//					d++;
//				}
//			}
//		}
//		return 0;
//	}
}
