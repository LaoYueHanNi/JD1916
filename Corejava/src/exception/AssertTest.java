package exception;

public class AssertTest {
	public static void main(String[] args) {
		System.out.println("start---");
		int b=0;
		//�Ӷ��� �ж�����:�쳣��������Ϣ
		//����Ĭ���ǹرյ�,����vm����-ea�򿪶���
		assert b==0:"assert error if b!=0";
		int k=10/0;
		System.out.println("K="+k);
		System.out.println("end---");
	}
}
