package com.briup.common;

import java.sql.*;

//jdbc的模板类
public class JDBCTemplate {
	private Connection conn;

	public JDBCTemplate() {
		this(null);
	}

	public JDBCTemplate(Connection conn) {
		if (conn == null)
			conn = ConnectionFactory.getConnection();
		this.conn = conn;
	}

//	sql语句:有输入值,有结果集(查询语句)
	public void excute(String sql, PrepareSetter ps, Handler handler) {
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement(sql);
			if(ps!=null)ps.setter(pst);
			pst.executeQuery();
			if(handler!=null)handler.handler(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, pst, rs);
		}
	}

//	sql语句:没有输入值,有结果集(查询语句)
	public void excute(String sql, Handler handler) {
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			//处理结果集
			if(handler!=null)handler.handler(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,st,rs);
		}
		
	}

//	sql语句:有输入值,没有有结果集(DML语句)
	public void excute(String sql, PrepareSetter ps) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			// 给输入值赋值
			if (ps != null)
				ps.setter(pst);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst);
		}
	}

//	sql语句:没有输入值,没有结果集的SQL(DML查询语句)
	public void excute(String sql) {
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, st);
		}
	}

}
