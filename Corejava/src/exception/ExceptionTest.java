package exception;

import com.briup.reflect.Dog;

//�����쳣
public class ExceptionTest {
	public static void main(String[] args) {
		System.out.println("start----");
		try {
		int k=10/2;
		System.out.println("k="+k);
//		Dog dog=null;
//		dog.print(1,2);
		}catch(NullPointerException e) {
			System.out.println("��ָ���쳣");
		}catch(Exception e) {
			System.out.println("�쳣");
		}finally{
			System.out.println("xiixhaa");
		}
		System.out.println("end----");
	}
}
