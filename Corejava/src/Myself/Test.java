package Myself;

public class Test {
	public static void main(String[] args) {
		List list =new ArrayList();
				//new LinkedList();s
		
		//ʹ�õ���������Ԫ��
		Iterator iter =list.iterator();
		while(iter.hasNext()) {
			Object obj=iter.next();
			System.out.print(obj+" ");
		}
	}
}
