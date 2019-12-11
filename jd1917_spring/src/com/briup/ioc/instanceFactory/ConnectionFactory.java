package com.briup.ioc.instanceFactory;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.FactoryBean;

// 需要Spring识别的工厂类
//泛型写产品的数据类型
public class ConnectionFactory {

	private String driver;
	private String url;
	private String user;
	private String password;

	// 返回产品对象
	public Connection getObject() throws Exception {
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
