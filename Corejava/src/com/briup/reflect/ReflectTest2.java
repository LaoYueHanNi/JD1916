package com.briup.reflect;
//���Է���:ͨ������һ�����������
	//����һ������ķ���
	//����һ����Ķ���(��ʹ��new)
import java.lang.reflect.*;

public class ReflectTest2 {
	public static void main(String[] args)throws Exception {
		//1��ȡ�������
		Class clz =Class.forName("com.briup.reflect.Dog");
		//2����������󴴽�Dog��Ķ���,��ʹ��new�ؼ��ִ���
		 Dog dog=(Dog) clz.newInstance();//��������һ��Class�Ķ���
		//3��������  ����.name="briup"
			//��ȡĳһ�����Զ���
		Field f=clz.getDeclaredField("name");
		f.setAccessible(true);//����Ȩ��
			//�������Ե�ֵ
		System.out.println(f.get(dog));
		f.set(dog, "jack");
			//��ȡ���Ե�ֵ
		System.out.println(f.get(dog));
		
		//4��������
		 	//��ȡ����
		Method method=clz.getMethod("print", int.class,int.class);
			//���÷���
		Object result=method.invoke(dog, 3,5);
		System.out.println("result:"+result);
		
	}
}
