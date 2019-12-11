package Myself;

public class LinkedList implements List{
	private Node head;//头节点
	private int size;
	
	public LinkedList() {
	//创建头节点
		head=new Node(null);
		head.next=null;
	}
	@Override
	public void add(Object obj) {
		Node curr=head;
		Node node=new Node(obj);
		for(int i=0;i<size;i++) {
			curr=curr.next;
		}
		curr.next=node;
		node.next=null;
		size++;
	}

	@Override
	public void add(int index, Object obj) {
		if(index<0||index>size)return;
		Node curr=head;//当前节点
		for(int i=0;i<index;i++) {
			curr=curr.next;
		}
		Node node=new Node(obj);
		node.next=curr.next;
		curr.next=node;
		size++;
	}

	@Override
	public void set(int index, Object obj) {
		Node curr=head;
		if(index<0||index>=size)return;
		for(int i=0;i<=index;i++) {
			curr=curr.next;
		}
//		Node n=(Node)obj;
//		curr=n;
		curr.setData(obj);
	}

	@Override
	public Object get(int index) {
		if(index<0||index>=size)return null;
		Node curr=head;//当前节点
		for(int i=0;i<=index;i++) {
			curr=curr.next;
		}
		return curr.getData();
	}

	@Override
	public Object remove(int index) {
		if(index<0||index>=size)return null;
		Node curr=head;
		Node pre=null;
		for(int i=0;i<=index;i++) {
			pre=curr;
			curr=curr.next;
		}
		pre.next=curr.next;
		size--;
		Object obj =curr.getData();
		curr.next=null;
		curr=null;
		return obj;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			private int position=-1;
			@Override
			public boolean hasNext() {
				if(position+1<size)return true;
				return false;
			}

			@Override
			public Object next() {
				return get(++position);
			}

			@Override
			public Object remove() {
				LinkedList.this.remove(position--);
				return null;
			}
			
		};
	}

}
