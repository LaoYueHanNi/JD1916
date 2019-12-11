package Myself;

public class Node {
	private Object data;// 数据
	public Node next;// 下一个节点的地址

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
