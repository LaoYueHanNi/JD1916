package com.briup.reflect;
import java.io.FileInputStream;
import java.util.*;
public class PropertiesTest {
	public static void main(String[] args) throws Exception{
		// �鿴ϵͳ����
		Properties p= System.getProperties();
		p.list(System.out);//�ڿ���̨�����
		//����һ��jvm��ϵͳ�������  _D
		//��ȡjvmϵͳ����Ĳ���
		System.out.println("-----");
		String value =p.getProperty("name");
		System.out.println(value);
		//��ȡ���򼶱�Ĳ���
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		
		//�ص�:��ȡ�ļ�(key==value)������
			//1 ��������
			Properties p1=new Properties();
			//p1.put(key, value);�Ž�
			// �����ļ�
			p1.load(new FileInputStream("src/com/briup/reflect/info.properties"));
			System.out.println(p1.getProperty("name"));
			System.out.println(p1.getProperty("age"));
			System.out.println(p1.getProperty("male"));
	}
}
