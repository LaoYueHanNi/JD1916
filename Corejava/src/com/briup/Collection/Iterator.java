package com.briup.Collection;
//迭代器：定义遍历数据结构中数据的规范
public interface Iterator {
	public boolean hasNext();//判断是否有下一个值
	public Object next();//取下一个值
	public Object remove();//删除迭代器当中的最后一个元素，即迭代器当前元素

}
