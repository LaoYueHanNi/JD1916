package innerClass;
//���Ծֲ��ڲ���
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
				//num=2;���Է��ʷ�����final���εı���
				int c=a+num;
			}
		}
		//�����ֲ��ڲ���
		LocalInner i=new LocalInner();
		i.test();
	}
}
