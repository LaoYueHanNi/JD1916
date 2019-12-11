package com.briup.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.briup.bean.Teacher;

import common.Handler;
import common.JDBCTemplate;
import common.PrepareSetter;


//Dao≤„ µœ÷¿‡
public class TeacherDaoImpl
			implements ITeacherDao{
	
	private JDBCTemplate temp;
	
	public  TeacherDaoImpl() {
		this(null);
	}
	public TeacherDaoImpl(JDBCTemplate temp){
		if(temp==null)
			temp = new JDBCTemplate();
		this.temp = temp;
	}
	
	@Override
	public Teacher findTeacherByName(String name) throws Exception {
		String sql="select * from s_teacher"
				+ " where name=?";
		Teacher t = new Teacher();
		temp.execute(sql,new PrepareSetter() {
			@Override
			public void setter(PreparedStatement pst) throws SQLException {
				pst.setString(1,name);
			}
		}, new Handler() {
			public void handler(ResultSet rs) throws SQLException {
				while(rs.next()) {
					t.setId(rs.getInt("id"));
					t.setName(rs.getString("name"));
					t.setAge(rs.getInt("age"));
					t.setPwd(rs.getString("pwd"));
				}
			}
		});
		return t;
	}
	@Override
	public void addTeacher(Teacher t) throws Exception {
		String sql="insert into s_teacher"
				+ " values(s_teacher_id.nextval"
						+ ",?,?,?)";
		temp.execute(sql,new PrepareSetter() {
			@Override
			public void setter(PreparedStatement pst) throws SQLException {
				pst.setString(1, t.getName());
				pst.setString(2, t.getPwd());
				pst.setInt(3, t.getAge());
			}
		});
	}

}
