package com.briup.work.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;



public class DBTest {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;

	static {
		Properties properties = new Properties();
		try {
			properties.load(DBTest.class.getResourceAsStream("db.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;
	}
	public static void main(String[] args) {
		try {
			System.out.println(new DBTest().getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
