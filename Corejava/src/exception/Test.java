package exception;

// 使用自定义的异常
public class Test {
	//把uncheck转换为check
	public static void a() throws FirstException {
		try {
			int k = 10 / 0;
		} catch (ArithmeticException e) {
			// 除数不能为0
			throw new ArithmeticException("除数不能为0");
		}
	}
	public static void b() {
		try {
			Class.forName("Dog");
		}catch(ClassNotFoundException e) {
			throw new SecondException("类名有误");
		}
	}

	public static void main(String[] args) throws FirstException{
		System.out.println("start---");
		a();
		System.out.println("end---");
	}
}
