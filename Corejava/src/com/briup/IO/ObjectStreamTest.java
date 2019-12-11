package com.briup.IO;
//测试读写对象
import java.io.*;


public class ObjectStreamTest {
	public static void main(String[] args) {
		//写对象到文件中(序列化)
		ObjectOutputStream oos=null;
		//从文件中读取对象(反序列化)
		ObjectInputStream ois=null;
		try {
			oos=new ObjectOutputStream(new FileOutputStream("src/com/briup/IO/emp.txt"));
			ois=new ObjectInputStream(new FileInputStream("src/com/briup/IO/emp.txt"));
			Employee e1=new Employee("tom",19,1000);
			Employee e2=new Employee("lili",33,30000);
			Employee e3=new Employee("ouyang",22,10000);
			Employee e4=new Employee("xule",32,20000);
			oos.writeObject(e1);
			oos.writeObject(e2);
			oos.writeObject(e3);
			oos.writeObject(e4);
			oos.flush();
			
			//读取对象
			Object o1=ois.readObject();
			Object o2=ois.readObject();
			Object o3=ois.readObject();
			Object o4=ois.readObject();
			
			
			System.out.println(o1.toString());
			System.out.println(o2.toString());
			System.out.println(o3.toString());
			System.out.println(o4.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
