package com.briup.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.common.ConnectionFactory;

public class TransactionTest {
	
	//测试事务
	public static void main(String[] args) {
		Connection conn=ConnectionFactory.getConnection();
		String sql1="insert into s_teacher values(563,'zs','123')";
		String sql2="update s_teacher set pwd='25'";
		Statement st=null;
		try {
			//开启事务,设置事务的提交方式
			conn.setAutoCommit(false);//变为手动提交
			st=conn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			//回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
