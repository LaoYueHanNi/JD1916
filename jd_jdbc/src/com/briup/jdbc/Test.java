package com.briup.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.common.Handler;
import com.briup.common.JDBCTemplate;
import com.briup.common.PrepareSetter;

// ����ģ����
public class Test {
	public static void main(String[] args) {
		JDBCTemplate temp=new JDBCTemplate();
		
		//delete from s_teacher û������ֵ,û�н����.
		//String sql1="delete from s_teacher";
		//temp.excute(sql1);
		
		//insert into ����,������ֵ,û�н����
//		String sql2="insert into s_teacher values(?,?,?)";
//		temp.excute(sql2, (PreparedStatement pst)->{
//				//��?��ֵ
//				pst.setInt(1, 1);
//				pst.setString(2, "Ou");
//				pst.setString(3, "2341");
//			}
//		);
		//select ����������ֵҲ����û������ֵ,�н����
//		String sql3="select * from s_teacher";
//		temp.excute(sql3, new Handler() {
//			public void handler(ResultSet rs) throws SQLException {
//				while(rs.next()) {
//					int id=rs.getInt("id");
//					String name=rs.getString("name");
//					System.out.println("id="+id+" name="+name);
//				}
//			}
//		});
		//select * from s_teacher where id=?��������ֵҲ�н����
//		String sql4="select * from s_teacher where id=?";
//		temp.excute(sql4, new PrepareSetter() {
//			public void setter(PreparedStatement pst) throws SQLException {
//				pst.setInt(1, 1);
//			}
//		}, new Handler() {
//			public void handler(ResultSet rs) throws SQLException {
//				while(rs.next()) {
//					int id=rs.getInt("id");
//					String name=rs.getString("name");
//					System.out.println("id="+id+" name="+name);
//				}
//			}
//		});
	} 
}
