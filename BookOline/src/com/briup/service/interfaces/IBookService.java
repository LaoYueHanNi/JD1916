package com.briup.service.interfaces;

import java.util.List;

import com.briup.bean.Book;
import com.briup.common.exception.BookException;

/**
 * 
 * Copyright: Copyright (c) 2017 wangzh
 * 
 * @see: IUserService.java
 * @Description: 用户管理Serivice
 *
 * @version: v1.0.0
 * @author: wangzh
 * @date: 2017�?9�?22�? 上午11:08:21 

 */
public interface IBookService {
	public List<Book> listAllBooks() throws BookException ;
	public Book findById(int id) throws BookException;
}
