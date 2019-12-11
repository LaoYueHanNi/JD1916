package com.briup.jdbc;
//JDBC的六大步骤
import java.sql.*;
import java.util.Properties;

public class SecondJDBC {
	public static void main(String[] args) {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//1)注册驱动(驱动类的名字)导入jar包
			//Class.forName("oracle.jdbc.driver.OracleDriver");//no1
			
			//Driver driver=new oracle.jdbc.driver.OracleDriver();
			//DriverManager.registerDriver(driver);//no2创建Driver
			
			//No3传入系统参数_Djdbc.drivers
			
			//2)-1获取数据库的连接,url:指定连接哪一个数据库,user,password:用户名和密码
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "briup", "briup");
			//2)-2从Driver对象中获取连接对象,和第一步的第二种连用
//			Properties info=new Properties();
//			info.put("user", "briup");//用户名
//			info.put("password", "briup");//密码
//			conn=driver.connect("jdbc:oracle:thin:@localhost:1521:XE", info);
			
			  //3)获取statement对象
			st = conn.createStatement();
			//4)执行sql语句
			String sql="select id,last_name,salary,start_date from s_emp";
			rs=st.executeQuery(sql);
			//5)出列结果集
			while(rs.next()) {
				//取出每行的数据
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
			//6) 关闭资源,(先开后关)
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
