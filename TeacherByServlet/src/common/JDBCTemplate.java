package common;

import java.security.spec.PSSParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//jdbc的模板类
public class JDBCTemplate {
	private Connection conn;
	
	public JDBCTemplate() {
		this(null);
	}
	public JDBCTemplate(Connection conn) {
		if(conn==null)
			conn = ConnectionFactory.getConnection();
		this.conn = conn;
	}
	
	//执行没有输入值，没有结果集的SQL
	public void execute(String sql){
		Statement st = null;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,st);
		}
	}
	//执行有输入值，没有结果集的SQL
	public void execute(String sql,
				PrepareSetter ps){
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			//给输入值赋值
			if(ps!=null)ps.setter(pst);
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, pst);
		}
	}
	//执行没有输入值，有结果集的SQL
	public void execute(String sql,
			        Handler handler) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//处理结果集
			if(handler!=null)handler.handler(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, st, rs);
		}
	} 
	//执行有输入值，有结果集的SQL
	public void execute(String sql,
			PrepareSetter ps,
	        Handler handler) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst=conn.prepareStatement(sql);
			if(ps!=null)ps.setter(pst);
			rs = pst.executeQuery();
			if(handler!=null)handler.handler(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, pst, rs);
		}
	} 
}
