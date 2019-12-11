package com.briup.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.common.ConnectionFactory;

public class ThirdJDBC {
	private static Object String;
	//ͨ��JDBC����һ�ű�
	public static void create() {
		//1)ע������//2)��ȡ����
		Connection conn=ConnectionFactory.getConnection();
		//3)��ȡstatement����
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
			//�ر���Դ
			
		}
		
	}
	//ͨ��JDBC����1������
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
	//�����ʦ����,ʹ��statement����
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
	//�����ʦ����,ʹ��Preparedstatement����
	public static void addT(Teacher teacher) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pst=null;
		try {
			String sql="insert into s_teacher"+
					" values(?,?,?)";
			pst=conn.prepareStatement(sql);
			//��ռλ����ֵ
			pst.setInt(1, teacher.getId());
			pst.setString(2, teacher.getName());
			pst.setString(3, teacher.getPwd());
			//ִ��sql���
			int count =pst.executeUpdate();
			System.out.println("count:"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//ͨ��JDBC����100������
		//ʹ��Statement���
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
	
		//ͨ��PreparedStatement
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
	//ͨ��JDBC��ѯһ������(��¼)
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
