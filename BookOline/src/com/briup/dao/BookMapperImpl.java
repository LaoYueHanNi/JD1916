package com.briup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.briup.bean.Book;
import com.briup.common.util.ConnectionFactory;

public class BookMapperImpl implements IBookMapper {

	private Connection conn;

	public BookMapperImpl() {
		conn = new ConnectionFactory().getConnection();
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> list = new ArrayList<Book>();
		Book book = new Book();
		try {
			Statement statement = conn.createStatement();
			String sql = "select id,name,price from tbl_book";
			
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				book.setId(rs.getLong(1));
				book.setName(rs.getString(2));
				book.setDesciption(rs.getString(3));
				book.setPrice(rs.getDouble(3));
				book.setCategoryId(rs.getLong(5));
				book.setWriter(rs.getString(6));
				book.setPublish(rs.getString(7));
				book.setPage(rs.getLong(8));
				book.setImage(rs.getString(9));

				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book findBookById(int id) {
		Book book = new Book();
		try {
			Statement statement = conn.createStatement();
			String sql = " select * from tbl_book where id=" + id;
			
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				book.setId(rs.getLong(1));
				book.setName(rs.getString(2));
				book.setDesciption(rs.getString(3));
				book.setPrice(rs.getDouble(4));
				book.setCategoryId(rs.getLong(5));
				book.setWriter(rs.getString(6));
				book.setPublish(rs.getString(7));
				book.setPage(rs.getLong(8));
				book.setImage(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	public static void main(String[] args) {
		System.out.println(new BookMapperImpl().findAllBooks());
		//System.out.println(new BookMapperImpl().findBookById(1));
	}
}
