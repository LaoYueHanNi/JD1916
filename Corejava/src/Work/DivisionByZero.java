package Work;

import java.util.Scanner;

//дDivisionByZero�࣬����
//1. division()��Ҫ��ִ��10/0��������ʹ���쳣������ƴ���������쳣
//2. main()������division()
//3. �޸�division()��ִ��10/0���䣬�����ڷ����д���������쳣���Ľ��쳣�׳�
//4. �޸�main()������division()���������׳����쳣

public class DivisionByZero {
	public static void main(String[] args) {
		try {
			division();
		} catch (Exception e) {
			
		}
		

	}

	public static void division() throws Exception {
		try {
			System.out.println(10/0);
		} catch (Exception e) {
			System.out.println("�����������");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			System.out.println(10 / a);
		}
	}
}
