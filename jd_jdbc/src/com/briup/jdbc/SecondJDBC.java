package com.briup.jdbc;
//JDBC��������
import java.sql.*;
import java.util.Properties;

public class SecondJDBC {
	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1)ע������(�����������)����jar��
			//Class.forName("oracle.jdbc.driver.OracleDriver");//no1
			
			//Driver driver=new oracle.jdbc.driver.OracleDriver();
			//DriverManager.registerDriver(driver);//no2����Driver
			
			//No3����ϵͳ����_Djdbc.drivers
			
			//2)-1��ȡ���ݿ������,url:ָ��������һ�����ݿ�,user,password:�û���������
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "briup", "briup");
			//2)-2��Driver�����л�ȡ���Ӷ���,�͵�һ���ĵڶ�������
//			Properties info=new Properties();
//			info.put("user", "briup");//�û���
//			info.put("password", "briup");//����
//			conn=driver.connect("jdbc:oracle:thin:@localhost:1521:XE", info);
			
			  //3)��ȡstatement����
			st = conn.createStatement();
			//4)ִ��sql���
			String sql="select id,last_name,salary,start_date from s_emp";
			rs=st.executeQuery(sql);
			//5)���н����
			while(rs.next()) {
				//ȡ��ÿ�е�����
				int id=rs.getInt(1);
				String last_name=rs.getString(2);
				Double salary=rs.getDouble(3);
				Date start_date=rs.getDate(4);
				System.out.println(id+" "+last_name+" "+salary+" "+start_date);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//6) �ر���Դ,(�ȿ����)
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
