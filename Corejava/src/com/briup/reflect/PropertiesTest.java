package com.briup.reflect;
import java.io.FileInputStream;
import java.util.*;
public class PropertiesTest {
	public static void main(String[] args) throws Exception{
		// 查看系统参数
		Properties p= System.getProperties();
		p.list(System.out);//在控制台上输出
		//设置一下jvm的系统级别参数  _D
		//获取jvm系统级别的参数
		System.out.println("-----");
		String value =p.getProperty("name");
		System.out.println(value);
		//获取程序级别的参数
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		
		//重点:读取文件(key==value)的内容
			//1 创建对象
			Properties p1=new Properties();
			//p1.put(key, value);放进
			// 加载文件
			p1.load(new FileInputStream("src/com/briup/reflect/info.properties"));
			System.out.println(p1.getProperty("name"));
			System.out.println(p1.getProperty("age"));
			System.out.println(p1.getProperty("male"));
	}
}
