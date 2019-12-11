package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.briup.bean.Book;
import com.briup.exception.BookException;

public interface BookDao {

	//��������ͼ��
	@Select("select * from es_book")
	@ResultMap("com.briup.dao.BookDao.BookResult")
	List<Book> findAllBooks() throws BookException;
	
	//��������Id��ѯ�鼮����Ϣ
	@Select("select bookid,name,price,author from es_book where category_id=#{id}")
	@ResultMap("com.briup.dao.BookDao.BookResult")
	List<Book> findBooksByCategoryId(int categoryId);
	
	//������Id��ѯ�鼮����Ϣ
	@Select("select * from es_book where bookid=#{id}")
	@ResultMap("com.briup.dao.BookDao.BookResult")
	Book findBookByBookId(int bookId);
	
	
	
}
