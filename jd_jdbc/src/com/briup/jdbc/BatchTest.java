package com.briup.jdbc;

import com.briup.common.ConnectionFactory;
import java.sql.*;

//����������
public class BatchTest {
	// ����һ��������
	// ʹ��Statement����������
	// ʹ��ͨ��PreparedStatement����������
	// ʹ��Statement��������
	public static void test1() {
		Connection conn=ConnectionFactory.getConnection();
		Statement st=null;
		try {
			st=conn.createStatement();
			conn.setAutoCommit(false);
			long start=System.currentTimeMillis();
			for(int i=0;i<10000;i++) {
				String sql="insert into s_teacher values("+i+",'zs','231')";
				//��sql������������
				st.addBatch(sql);
				if(i%200==0) {
					st.executeBatch();
				}
			}
			st.executeBatch();
			conn.commit();
			long end=System.currentTimeMillis();
			System.out.println("time="+(end-start));
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// ʹ��ͨ��PreparedStatement��������
	public static void test2() {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pst=null;
		try {
			String sql="insert into s_teacher values(?,?,?)";
			pst=conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			long start=System.currentTimeMillis();
			for(int i=0;i<10000;i++) {
				pst.setInt(1,i);
				pst.setString(2, "zs");
				pst.setString(3, "231");
				pst.addBatch();
				if(i%200==0) {
					pst.executeBatch();
				}
			}
			pst.executeBatch();
			conn.commit();
			long end=System.currentTimeMillis();
			System.out.println("time="+(end-start));
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		//test1();
		test2();
	}
}
