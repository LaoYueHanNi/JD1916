package com.briup.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.briup.db.bean.Student;

@Repository("stuDaoImp")
public class StudentDaoImplByJDBCTemp implements IStudentDao {
	private JdbcTemplate temp;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.temp = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Student> selectStudents() {
		List<Student> list = temp.query("select * from student", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				return stu;
			}
		});
		return list;
	}

	@Override
	public Student selectStudentById(int id) {
		Student stu = temp.queryForObject("select * from student where id = ?", new Object[] { id },
				new RowMapper<Student>() {
					@Override
					public Student mapRow(ResultSet rs, int arg1) throws SQLException {
						Student stu = new Student();
						stu.setId(rs.getInt("id"));
						stu.setName(rs.getString("name"));
						return stu;
					}
				});
		return stu;
	}

	@Override
	public List<Student> selectStudentByName(String name) {
		return null;
	}

	@Override
	public void deleteStudentById(int id) {
		temp.update("delete from student where id = ?", id);
	}

	@Override
	public void addStudent(Student stu) {
		temp.update("insert into student values(?,?,?,?,?)", stu.getId(), stu.getName(), stu.getGender(),
				stu.getMajor(), stu.getGender());
	}

}
