package Myself;

public class ArrayList implements List {
	private Object array[];// 定义一个object的数组，可以存放任意类型
	private int size;// 定义size存储当前数组元素个数，在添加时注意++
	private int length;// 定义数组的长度

	public ArrayList() {
		this(10);// 调用的时候不写参数，默认调用一餐10，定义为10长度的数组
	}

	public ArrayList(int length) {
		// 一参构造函数
		array = new Object[length];
		this.length = length;
	}

	@Override
	public void add(Object obj) {
		array[size] = obj;// 目前有size个数，添加的话会添加到size下标上
		size++;// 添加完之后size数加1
	}

	public void check() {
		// 判断是否需要扩容，以及扩容,当size大于等于长度时扩容，其实就是等于长度时扩容
		if (size >= length) {
			Object[] narray = new Object[length + 5];
			System.arraycopy(array, 0, narray, 0, size);
			array = narray;
			this.length += 5;
		}

	}

	@Override
	public void add(int index, Object obj) {
		// 在指定得下标插入一个元素，后面的元素要往后移
		// Object narray=new Object[length+1];失败思想
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
			return null;// 判断移除得对象是否存在
		Object ob1 = array[index];
//		for(int i=index;i<size-1;i++) {
//			array[index]=array[index+1];//使用for循环往前替代
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
		// 内部类实现迭代器接口，因为要使用当前类
		private int position = -1;

		@Override
		public boolean hasNext() {
			// 判断是否有下一个值
			if (position + 1 < size)
				return true;
			return false;
		}

		@Override
		public Object next() {
			// 获取下一个值
			return get(++position);
		}

		@Override
		public Object remove() {
			// 移除

			ArrayList.this.remove(position--);
			return null;
		}

	}
}
