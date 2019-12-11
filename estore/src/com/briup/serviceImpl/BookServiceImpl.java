package com.briup.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.common.MyBatisSqlSessionFactory;
import com.briup.dao.BookDao;
import com.briup.service.IBookService;

public class BookServiceImpl implements IBookService{

	@Override
	public List<Book> getBooksByCategoryId(int categoryId) {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		List<Book> list = null;
		BookDao mapper = session.getMapper(BookDao.class);
		try {
			 list = mapper.findBooksByCategoryId(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return list;
	}

	@Override
	public Book getBookByBookId(int bookId) {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		Book book = null;
		BookDao mapper = session.getMapper(BookDao.class);
		try {
			 book = mapper.findBookByBookId(bookId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return book;
	}


}
