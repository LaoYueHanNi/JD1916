package com.briup.Collection;
//  �ṩ���ݲ����Ĺ淶
public interface List {
	public void add(int index,Object obj);//��ָ��λ����Ӷ���
	public void add(Object obj);//��ĩβ��Ӷ���
	public Object remove(int index);//ɾ��ָ��λ�õĶ���
	public Object get(int index);//��ȡָ��λ�õĶ���
	public int size();//��ȡ���ݵĸ���
	public void set(int index,Object obj);//��ָ��λ���ϵ������޸�
	public Iterator iterator();//ʹ�õ������������ݽṹ
}
