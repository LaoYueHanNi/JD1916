package com.briup.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.common.ConnectionFactory;

public class TransactionTest {
	
	//��������
	public static void main(String[] args) {
		Connection conn=ConnectionFactory.getConnection();
		String sql1="insert into s_teacher values(563,'zs','123')";
		String sql2="update s_teacher set pwd='25'";
		Statement st=null;
		try {
			//��������,����������ύ��ʽ
			conn.setAutoCommit(false);//��Ϊ�ֶ��ύ
			st=conn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			//�ع�����
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
