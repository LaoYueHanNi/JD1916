package exception;

// ʹ���Զ�����쳣
public class Test {
	//��uncheckת��Ϊcheck
	public static void a() throws FirstException {
		try {
			int k = 10 / 0;
		} catch (ArithmeticException e) {
			// ��������Ϊ0
			throw new ArithmeticException("��������Ϊ0");
		}
	}
	public static void b() {
		try {
			Class.forName("Dog");
		}catch(ClassNotFoundException e) {
			throw new SecondException("��������");
		}
	}

	public static void main(String[] args) throws FirstException{
		System.out.println("start---");
		a();
		System.out.println("end---");
	}
}
