package innerClass;

//���Ծ�̬�ڲ���
public class StaticInnerTest {
	private int a = 10;
	private static int b = 20;
	
	public void test() {
		StaticInner.c=1;
		new StaticInner().b=11;
	}

	static class StaticInner {
		private int i;
		private static int c;
		private int b=30;

		public StaticInner() {

		}

		public void ha() {
			//a=20;��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Դ
			new StaticInnerTest().a=10;//�������������ʷǾ�̬��Դ
			StaticInnerTest.b=20;
		}

		public static void hah() {
			//a=20;
			new StaticInner().b=22;// ��̬���������ڲ���ķǾ�̬��ԴҲҪ�����ڲ���Ķ���
		}
	}
}
