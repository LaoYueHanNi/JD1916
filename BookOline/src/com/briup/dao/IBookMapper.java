package com.briup.dao;

import java.util.List;

import com.briup.bean.Book;

public interface IBookMapper {
	public List<Book> findAllBooks();
	public Book findBookById(int id);
}
