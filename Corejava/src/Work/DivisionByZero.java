package Work;

import java.util.Scanner;

//写DivisionByZero类，包含
//1. division()：要求执行10/0操作，并使用异常处理机制处理产生的异常
//2. main()：调用division()
//3. 修改division()：执行10/0不变，但不在方法中处理产生的异常，改将异常抛出
//4. 修改main()：调用division()并处理其抛出的异常

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
			System.out.println("重新输入除数");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			System.out.println(10 / a);
		}
	}
}
