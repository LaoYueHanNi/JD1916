package com.briup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
	public static void main(String[] args)
			throws Exception{
		//1)ע������(����������),����jar��
		Class.forName(
		"oracle.jdbc.driver.OracleDriver");
		//2)��ȡ�����ݿ������(url,
				//�û���������)
		Connection conn =
			DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:XE",
			"briup","briup");
		//3)��ȡStatement����
		Statement st = conn.createStatement();
		//4)ִ��SQL���
		String sql="select id,last_name,salary"
				  + " from s_emp";
		ResultSet rs = st.executeQuery(sql);
		//5)��������(ResultSet)
		while(rs.next()){
			int id=rs.getInt(1);//idֵ
			String name=rs.getString(2);
			double sal=rs.getDouble(3);
			System.out.println(id+" "+
					name+" "+sal);
		}
		//6)�ر���Դ
	}
}
