package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Category;
import com.briup.bean.Order;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.dao.BookDao;
import com.briup.dao.CategoryDao;
import com.briup.dao.OrderDao;
import com.briup.service.IBookService;
import com.briup.serviceImpl.BookServiceImpl;

public class Test1 {
	
	@Test
	public void testFindCategory() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		CategoryDao mapper = session.getMapper(CategoryDao.class);
		try {
			List<Category> list = mapper.findAllCategoryWithSon();
			
			//Category ca = mapper.findCategoryById(1);
			for( Category c :list) {
				System.out.println(c);
			}
			 
			//System.out.println(ca);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	@Test
	public void testFindBook() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		BookDao mapper = session.getMapper(BookDao.class);
		try {
			List list = mapper.findBooksByCategoryId(14);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	@Test
	public void ss() {
		IBookService service = new BookServiceImpl();
		//System.out.println(service.getBookByBookId(1));
		System.out.println(service.getBooksByCategoryId(14));
		
	}
	
	@Test
	public void testOrder() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		OrderDao mapper = session.getMapper(OrderDao.class);
		try {
			List<Order> order  = mapper.selectOrder(1);
			System.out.println(order);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
}
