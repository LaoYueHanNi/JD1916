package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.briup.bean.Book;
import com.briup.exception.BookException;

public interface BookDao {

	//查找所有图书
	@Select("select * from es_book")
	@ResultMap("com.briup.dao.BookDao.BookResult")
	List<Book> findAllBooks() throws BookException;
	
	//根据种类Id查询书籍的信息
	@Select("select bookid,name,price,author from es_book where category_id=#{id}")
	@ResultMap("com.briup.dao.BookDao.BookResult")
	List<Book> findBooksByCategoryId(int categoryId);
	
	//根据书Id查询书籍的信息
	@Select("select * from es_book where bookid=#{id}")
	@ResultMap("com.briup.dao.BookDao.BookResult")
	Book findBookByBookId(int bookId);
	
	
	
}
