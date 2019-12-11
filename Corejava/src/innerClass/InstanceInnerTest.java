package innerClass;
//实例实例内部类
public class InstanceInnerTest {
	private int a;
	private static int b;
	
	public void test() {
		a=10;
		b=10;
		InstanceInner i=new InstanceInner();
		i.a=10;
		i.b=10;
	}
	
	 public class InstanceInner{
		 private int a=10;
		 private int b=10;
		// private static int num=10;实例内部类只能定义非静态的资源
		 public InstanceInner() {
	
		 }
		 public void print() {
			 a=10;
			 new InstanceInnerTest().a=10;
			 InstanceInnerTest.b=1;
			 this.b=10;
	 }
	 }
}
