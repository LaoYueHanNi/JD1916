package com.briup.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.FactoryBean;

// ��ҪSpringʶ��Ĺ�����
//����д��Ʒ����������
public class ConnectionFactory implements FactoryBean<Connection> {

	private String driver;
	private String url;
	private String user;
	private String password;

	// ���ز�Ʒ����
	@Override
	public Connection getObject() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}

	// ���ز�Ʒ�������������
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	// ���ز�Ʒ�������������
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
