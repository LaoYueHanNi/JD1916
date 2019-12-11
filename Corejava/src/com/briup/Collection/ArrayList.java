package com.briup.Collection;

//采用数组实现
public class ArrayList implements List {
	private Object[] array;
	private int size;
	private int length;

	public ArrayList() {
		this(10);
	}

	public ArrayList(int length) {
		array = new Object[length];
		this.length = length;
	}

	private void check() {
		// 检查数据结构是否满了，满了就扩充容量
		if (size >= length) {
			Object[] nArray = new Object[length + 5];
			System.arraycopy(array, 0, nArray, 0, size);
			array = nArray;
			this.length += 5;
		}
	}

	@Override
	public void add(Object obj) {
		add(size, obj);
	}

	@Override
	public void add(int index, Object obj) {
		if (index < 0 || index > size)
			return;
		check();
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public Object remove(int index) {
		if (index < 0 || index >= size)
			return null;
		Object obj = array[index];
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		array[--size] = null;
		return obj;
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index >= size)
			return null;
		return array[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void set(int index, Object obj) {
		if (index < 0 || index >= size)
			return;
		array[index] = obj;
	}

	@Override
	public Iterator iterator() {
		return null;
	}

	// 因为迭代器要调用当前类中的数组，所以用内部类
	class ListIterator implements Iterator {
		private int position = -1;// 代表迭代器的位置，从-1开始

		@Override
		public boolean hasNext() {
			if (position + 1 < size)
				return true;
			return false;
		}

		@Override
		public Object next() {
			
			return get(++position);
		}

		@Override
		public Object remove() {
			ArrayList.this.remove(position--);
			return null;
		}
	}
}
