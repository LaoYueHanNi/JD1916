package exception;

public class AssertTest {
	public static void main(String[] args) {
		System.out.println("start---");
		int b=0;
		//加断言 判断条件:异常的描述信息
		//断言默认是关闭的,传入vm参数-ea打开断言
		assert b==0:"assert error if b!=0";
		int k=10/0;
		System.out.println("K="+k);
		System.out.println("end---");
	}
}
