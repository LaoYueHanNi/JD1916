package innerClass;
//在其他类中调用内部类
public class Test {
	public static void main(String[] args) {
		StaticInnerTest.StaticInner i1=new StaticInnerTest.StaticInner();
		i1.ha();
		i1.hah();
	}
}
