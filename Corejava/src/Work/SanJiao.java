package Work;

import java.util.Scanner;

public class SanJiao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������߳�");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		new SanJiao().isTriangle(a, b, c);

		double p = (double)(a + b + c) / 2;
		System.out.println("���Ϊ:" + (Math.sqrt(p * (p - a) * (p - b) * (p - c))));

	}

	public void isTriangle(int a, int b, int c) {
		if (a + b > c && a + c > b && c + b > a) {
			System.out.println("���������߳�Ϊ" + a + " " + b + " " + c);
			
		} else {
			
			throw new IllegalArgumentException("a,b,c���ܹ���������");
		}

	}
}
