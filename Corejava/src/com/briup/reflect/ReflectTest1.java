package com.briup.reflect;

//���Է���:ͨ�������������ȡclass������������,���з���,���еĹ���������Ϣ
import java.lang.reflect.*;

public class ReflectTest1 {
	public static void main(String[] args) throws Exception {
		// 1,��ȡ��дClass����
		Class clz = Class.forName("com.briup.reflect.Dog");
		System.out.println(clz);
		// ��ȡDog�������е�����
		Field[] fs = clz.getDeclaredFields();
		for (Field temp : fs) {
			// ���Ե����η�
			int mofiy = temp.getModifiers();
			// ���Ե�����
			String name = temp.getName();
			// ���Ե���������
			Class c = temp.getType();
			System.out.println(mofiy + " " + name + " " + c);
		}
		// ��ȡDog�����з���
		Method[] method = clz.getDeclaredMethods();
		for (Method temp : method) {
			// ������
			String name=temp.getName();
			// ���η�
			int mofiy=temp.getModifiers();
			// ��������ֵ����
			Class[] p=temp.getParameterTypes();
			// �����б�
			Class r=temp.getReturnType();
			System.out.print(mofiy+" "+r+" "+name+"(");
			String sp="";
			for(Class pp:p) {
				System.out.print(sp);
				System.out.print(pp);
				sp=",";
			}
			System.out.print(")");
			System.out.println();
		}
		//��ȡ�����б�
		Constructor[] cons=clz.getDeclaredConstructors();
		for(Constructor con:cons) {
			//�������Ĳ����б�
			//�����������η�
		}
	}
}
