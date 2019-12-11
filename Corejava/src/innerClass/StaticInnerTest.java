package innerClass;

//测试静态内部类
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
			//a=20;静态内部类只能访问外部类的静态资源
			new StaticInnerTest().a=10;//创建对象来访问非静态资源
			StaticInnerTest.b=20;
		}

		public static void hah() {
			//a=20;
			new StaticInner().b=22;// 静态方法访问内部类的非静态资源也要创建内部类的对象
		}
	}
}
