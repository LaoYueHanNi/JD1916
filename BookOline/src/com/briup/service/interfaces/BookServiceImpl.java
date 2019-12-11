package com.briup.service.interfaces;

import java.util.List;

import com.briup.bean.Book;
import com.briup.common.exception.BookException;
import com.briup.dao.BookMapperImpl;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> listAllBooks() throws BookException {
		List<Book> allBooksList = new BookMapperImpl().findAllBooks();
		
		return allBooksList;
	}

	@Override
	public Book findById(int id) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

}
