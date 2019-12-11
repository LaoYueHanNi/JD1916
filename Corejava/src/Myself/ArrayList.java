package Myself;

public class ArrayList implements List {
	private Object array[];// ����һ��object�����飬���Դ����������
	private int size;// ����size�洢��ǰ����Ԫ�ظ����������ʱע��++
	private int length;// ��������ĳ���

	public ArrayList() {
		this(10);// ���õ�ʱ��д������Ĭ�ϵ���һ��10������Ϊ10���ȵ�����
	}

	public ArrayList(int length) {
		// һ�ι��캯��
		array = new Object[length];
		this.length = length;
	}

	@Override
	public void add(Object obj) {
		array[size] = obj;// Ŀǰ��size��������ӵĻ�����ӵ�size�±���
		size++;// �����֮��size����1
	}

	public void check() {
		// �ж��Ƿ���Ҫ���ݣ��Լ�����,��size���ڵ��ڳ���ʱ���ݣ���ʵ���ǵ��ڳ���ʱ����
		if (size >= length) {
			Object[] narray = new Object[length + 5];
			System.arraycopy(array, 0, narray, 0, size);
			array = narray;
			this.length += 5;
		}

	}

	@Override
	public void add(int index, Object obj) {
		// ��ָ�����±����һ��Ԫ�أ������Ԫ��Ҫ������
		// Object narray=new Object[length+1];ʧ��˼��
		check();
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public void set(int index, Object obj) {
		if (index >= size || index < 0)
			return;
		array[index] = obj;
	}

	@Override
	public Object get(int index) {
		return array[index];
	}

	@Override
	public Object remove(int index) {
		if (index >= size || index < 0)
			return null;// �ж��Ƴ��ö����Ƿ����
		Object ob1 = array[index];
//		for(int i=index;i<size-1;i++) {
//			array[index]=array[index+1];//ʹ��forѭ����ǰ���
//		}
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		array[size--] = null;
		return ob1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		return new ListIterator();
	}

	class ListIterator implements Iterator {
		// �ڲ���ʵ�ֵ������ӿڣ���ΪҪʹ�õ�ǰ��
		private int position = -1;

		@Override
		public boolean hasNext() {
			// �ж��Ƿ�����һ��ֵ
			if (position + 1 < size)
				return true;
			return false;
		}

		@Override
		public Object next() {
			// ��ȡ��һ��ֵ
			return get(++position);
		}

		@Override
		public Object remove() {
			// �Ƴ�

			ArrayList.this.remove(position--);
			return null;
		}

	}
}
