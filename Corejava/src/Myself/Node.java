package Myself;

public class Node {
	private Object data;// ����
	public Node next;// ��һ���ڵ�ĵ�ַ

	public Node(Object data) {
		this.data = data;
	}

	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
