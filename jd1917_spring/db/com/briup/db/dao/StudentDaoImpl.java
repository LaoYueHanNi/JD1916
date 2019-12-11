package com.briup.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.briup.db.bean.Student;

public class StudentDaoImpl implements IStudentDao{

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	@Override
	public List<Student> selectStudents() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection conn = dataSource.getConnection();
			Statement state = conn.createStatement();
			String sql = "select * from student";
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt(1));
				stu.setName(rs.getString(2));
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		return list;
	}

	@Override
	public Student selectStudentById(int id) {
		return null;
	}

	@Override
	public List<Student> selectStudentByName(String name) {
		return null;
	}

	@Override
	public void deleteStudentById(int id) {
		
	}

	@Override
	public void addStudent(Student stu) {
		Connection conn = DataSourceUtils.getConnection(dataSource);
		String sql ="insert into student values(?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, stu.getId());
			pst.setString(2, stu.getName());
			pst.setString(3, stu.getGender());
			pst.setString(4, stu.getMajor());
			pst.setString(5, stu.getGrade());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
