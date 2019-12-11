package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

public interface IBookService {
	//根据种类id获取书籍
	public List<Book> getBooksByCategoryId(int categoryId);
	//根据bookid获取书籍详细信息
	public Book getBookByBookId(int bookId);
}
