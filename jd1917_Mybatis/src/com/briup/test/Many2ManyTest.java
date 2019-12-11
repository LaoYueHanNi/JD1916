package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.many2many.Course;
import com.briup.many2many.Student;
import com.briup.mappers.Many2ManyMapper;

public class Many2ManyTest {
	//�������ѧ��
	@Test
	public void test_insertStudent(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
				 
			mapper.insertStudent(new Student("����","��","�����","����"));
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	//������ӿγ�
	@Test
	public void test_insertCourse(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
				
			mapper.insertCourse(new Course("001","Servlet"));
			mapper.insertCourse(new Course("002","JSP"));
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	//����ѡ�ι���
	@Test
	public void test_studentSelectCourse(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			Student student = mapper.getStudentById(1);
			Course course = mapper.getCourseById(23);
			
			mapper.studentSelectCourse(student, course);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	//���Բ�ѯ��ָ��idֵС��ѧ����Ϣ
	@Test
	public void test_getStudentByIdOnCondition(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			List<Student> list = mapper.getStudentByIdOnCondition(20);
			
			for(Student s:list){
				System.out.println(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	//���Բ�ѯstudent������ѯ����ѡ��course������װ�������Ķ���
	@Test
	public void test_getStudentByIdWithCourses(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			Student student = mapper.getStudentByIdWithCourses(1);
			
			System.out.println(student);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	@Test
	public void testDeleteStuAndTableMsg() {
		//ɾ��ѧ������Ϣ,��ͬ��ѧ����ѡ��ѡ�μ�¼ҲҪɾ�� 
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			mapper.deleteTableMsg(1);
			mapper.deleteStudent(1);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	@Test
	public void findAllCoursesWithStu() {
		//ɾ��ѧ������Ϣ,��ͬ��ѧ����ѡ��ѡ�μ�¼ҲҪɾ�� 
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			List<Course> list = mapper.getAllCoursesWithStudent();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
}
