package com.briup.common;

import java.sql.*;

//jdbc��ģ����
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

//	sql���:������ֵ,�н����(��ѯ���)
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

//	sql���:û������ֵ,�н����(��ѯ���)
	public void excute(String sql, Handler handler) {
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			//���������
			if(handler!=null)handler.handler(rs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,st,rs);
		}
		
	}

//	sql���:������ֵ,û���н����(DML���)
	public void excute(String sql, PrepareSetter ps) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			// ������ֵ��ֵ
			if (ps != null)
				ps.setter(pst);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, pst);
		}
	}

//	sql���:û������ֵ,û�н������SQL(DML��ѯ���)
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