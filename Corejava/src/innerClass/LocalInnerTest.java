package innerClass;
//测试局部内部类
public class LocalInnerTest {
	private int a;
	private static int b;
	
	public void test() {
	}
	
	public void print() {
		int num =10;
		class LocalInner{
			private int a1;
			public LocalInner() {
				
			}
			
			public void test() {
				LocalInnerTest.this.a=1;
				b=2;
				//num=2;可以访问方法内final修饰的变量
				int c=a+num;
			}
		}
		//创建局部内部类
		LocalInner i=new LocalInner();
		i.test();
	}
}
