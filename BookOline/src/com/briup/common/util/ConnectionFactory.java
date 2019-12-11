package com.briup.common.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//获取COnnection对象
import java.sql.*;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		//对静态变量进行初始化
		Properties p=new Properties();
		try {
			//p.load(new FileInputStream("src/com/briup/common/util/db.properties"));
			//第二种,从当前路径内获取 
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
	public Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
			//数据库连接失败之后就不需要再往下执行了
			throw new RuntimeException("连接失败");//直接中断程序运行
		}
		return conn;
	}
	public static void main(String[] args) {
		System.out.println(new ConnectionFactory().getConnection());
	}
}
