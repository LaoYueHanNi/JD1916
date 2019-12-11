package com.briup.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.common.ConnectionFactory;

public class Work_1 {
	public static void create() {
		Connection conn = ConnectionFactory.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "create table t_user(id number(10) primary key,name varchar2(10) not null,age number(3))";
			boolean result = st.execute(sql);
			System.out.println("result:" + result);
		} catch (Exception e) {

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// create();
	}
}
