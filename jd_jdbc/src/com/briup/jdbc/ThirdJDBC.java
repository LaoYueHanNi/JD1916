package com.briup.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.common.ConnectionFactory;

public class ThirdJDBC {
	private static Object String;
	//通过JDBC创建一张表
	public static void create() {
		//1)注册驱动//2)获取连接
		Connection conn=ConnectionFactory.getConnection();
		//3)获取statement对象
		Statement st=null;
		try {
			st=conn.createStatement();
			String sql="create table s_teacher(id number(5) primary key,"
					+ "name varchar2(10) not null,"+"age number(10) not null,pwd varchar2(10))";
			boolean result = st.execute(sql);
			System.out.println("result:"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭资源
			
		}
		
	}
	//通过JDBC插入1条数据
	public static void addTeacher() {
		Connection conn=ConnectionFactory.getConnection();
		Statement st=null;
		try {
			st=conn.createStatement();
			String sql="insert into s_teacher values(1,'jack','123')";
			int count=st.executeUpdate(sql);
			System.out.println("count:"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//添加老师对象,使用statement对象
	public static void addTeacher(Teacher teacher) {
		Connection conn=ConnectionFactory.getConnection();
		Statement st=null;
		try {
			st=conn.createStatement();
			String sql="insert into s_teacher values("+
					teacher.getId()+",'"+teacher.getName()+"','"+
					teacher.getPwd()+"')";
			int count=st.executeUpdate(sql);
			System.out.println("count:"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//添加老师对象,使用Preparedstatement对象
	public static void addT(Teacher teacher) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pst=null;
		try {
			String sql="insert into s_teacher"+
					" values(?,?,?)";
			pst=conn.prepareStatement(sql);
			//给占位符赋值
			pst.setInt(1, teacher.getId());
			pst.setString(2, teacher.getName());
			pst.setString(3, teacher.getPwd());
			//执行sql语句
			int count =pst.executeUpdate();
			System.out.println("count:"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//通过JDBC插入100条数据
		//使用Statement完成
	public static void insertBySt() {
		Connection conn=ConnectionFactory.getConnection();
		Statement st=null;
		try {
			st=conn.createStatement();
			long start=System.currentTimeMillis();
			for(int i=10;i<110;i++) {
				String sql="insert into s_teacher values("+i+",'jack','123')";
				st.executeUpdate(sql);
			}
			long end=System.currentTimeMillis();
			System.out.println("time="+(end-start));
		}catch(Exception e) {
			
		}finally {
			
		}
	}
	
		//通过PreparedStatement
	public static void insertByPSt() {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pst=null;
		try {
			String sql="insert into s_teacher values(?,?,?)";
			pst=conn.prepareStatement(sql);
			long start=System.currentTimeMillis();
			for(int i=110;i<210;i++) {
				pst.setInt(1,i);
				pst.setString(2, "tom");
				pst.setString(3, "687698");
				pst.executeUpdate();
			}
			long end=System.currentTimeMillis();
			System.out.println("time="+(end-start));
		}catch(Exception e) {
			
		}finally {
			
		}
	}
	//通过JDBC查询一条数据(登录)
	public static void Load(int id,String pwd) {
		Connection conn=ConnectionFactory.getConnection();
		Statement st=null;
		try {
			st=conn.createStatement();
			String sql="select * from s_teacher where id='"+id+"' and pwd='"+pwd+"'";
			ResultSet result=st.executeQuery(sql);
			while(result.next()) {
				System.out.println("id="+id+"name="+result.getString("name"));
			}
		}catch(Exception e) {
			
		}finally {
			
		}
	}
	public static void main(String[] args) {
		create();
		//addTeacher();
		Teacher t=new Teacher(3,"hank","2323");
		//addTeacher(t);
		//addT(t);
		//insertBySt();
		//insertByPSt();
		//Load(143,"687698");
	}
	
	
}
