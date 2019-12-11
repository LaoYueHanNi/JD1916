package com.briup.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//�ر���Դ
public class DBUtil {
	public static void close(Connection conn,Statement st,ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,Statement st) {
		close(conn,st,null);
	}
	public static void close(Connection conn) {
		close(conn,null);
	}
}
