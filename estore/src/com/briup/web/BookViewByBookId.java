package com.briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.service.IBookService;
import com.briup.serviceImpl.BookServiceImpl;

/**
 * Servlet implementation class BookViewByBookId
 */
@WebServlet("/BookViewByBookId")
public class BookViewByBookId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		IBookService service = new BookServiceImpl();
		if(bookId!=null) {
			int id = Integer.parseInt(bookId);
			Book book = service.getBookByBookId(id);
			HttpSession session = request.getSession();
			session.setAttribute("book", book);
			response.sendRedirect(request.getContextPath()+"/viewBook.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
