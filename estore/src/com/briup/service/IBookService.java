package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

public interface IBookService {
	//��������id��ȡ�鼮
	public List<Book> getBooksByCategoryId(int categoryId);
	//����bookid��ȡ�鼮��ϸ��Ϣ
	public Book getBookByBookId(int bookId);
}
