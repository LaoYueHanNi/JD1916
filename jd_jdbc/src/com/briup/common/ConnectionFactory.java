package com.briup.common;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//��ȡCOnnection����
import java.sql.*;
import java.util.Properties;

import javax.management.RuntimeErrorException;
public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		//�Ծ�̬�������г�ʼ��
		Properties p=new Properties();
		try {
			//p.load(new FileInputStream("src/com/briup/common/db.properties"));
			//�ڶ���,�ӵ�ǰ·���ڻ�ȡ 
			p.load(ConnectionFactory.class.getResourceAsStream("db.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver=p.getProperty("driver");
		url=p.getProperty("url");
		user=p.getProperty("user");
		password=p.getProperty("password");
	}
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
			//���ݿ�����ʧ��֮��Ͳ���Ҫ������ִ����
			throw new RuntimeException("����ʧ��");//ֱ���жϳ�������
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(ConnectionFactory.getConnection());
	}
}
