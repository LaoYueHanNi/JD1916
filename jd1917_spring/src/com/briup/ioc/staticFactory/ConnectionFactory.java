package com.briup.ioc.staticFactory;

import java.sql.Connection;
import java.sql.DriverManager;


// 需要Spring识别的工厂类
//泛型写产品的数据类型
public class ConnectionFactory {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "briup";
	private static String password = "briup";

	// 返回产品对象
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	// 返回产品对象的数据类型
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	// 返回产品对象的数据类型
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}


}
