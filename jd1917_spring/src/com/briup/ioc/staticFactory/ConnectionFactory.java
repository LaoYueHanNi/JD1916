package com.briup.ioc.staticFactory;

import java.sql.Connection;
import java.sql.DriverManager;


// ��ҪSpringʶ��Ĺ�����
//����д��Ʒ����������
public class ConnectionFactory {

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "briup";
	private static String password = "briup";

	// ���ز�Ʒ����
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	// ���ز�Ʒ�������������
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	// ���ز�Ʒ�������������
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
