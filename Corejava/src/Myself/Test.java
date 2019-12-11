package Myself;

public class Test {
	public static void main(String[] args) {
		List list =new ArrayList();
				//new LinkedList();s
		
		//使用迭代器遍历元素
		Iterator iter =list.iterator();
		while(iter.hasNext()) {
			Object obj=iter.next();
			System.out.print(obj+" ");
		}
	}
}
