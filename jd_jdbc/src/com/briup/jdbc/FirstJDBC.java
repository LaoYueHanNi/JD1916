package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
	public static void main(String[] args)
			throws Exception{
		//1)注册驱动(驱动的类名),导入jar包
		Class.forName(
		"oracle.jdbc.driver.OracleDriver");
		//2)获取与数据库的连接(url,
				//用户名，密码)
		Connection conn =
			DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:XE",
			"briup","briup");
		//3)获取Statement对象
		Statement st = conn.createStatement();
		//4)执行SQL语句
		String sql="select id,last_name,salary"
				  + " from s_emp";
		ResultSet rs = st.executeQuery(sql);
		//5)处理结果集(ResultSet)
		while(rs.next()){
			int id=rs.getInt(1);//id值
			String name=rs.getString(2);
			double sal=rs.getDouble(3);
			System.out.println(id+" "+
					name+" "+sal);
		}
		//6)关闭资源
	}
}
