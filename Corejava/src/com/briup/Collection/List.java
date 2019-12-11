package com.briup.Collection;
//  提供数据操作的规范
public interface List {
	public void add(int index,Object obj);//在指定位置添加对象
	public void add(Object obj);//在末尾添加对象
	public Object remove(int index);//删除指定位置的对象
	public Object get(int index);//获取指定位置的对象
	public int size();//获取数据的个数
	public void set(int index,Object obj);//将指定位置上的数据修改
	public Iterator iterator();//使用迭代器遍历数据结构
}
