package com.briup.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.service.IBookService;
import com.briup.serviceImpl.BookServiceImpl;

@WebServlet("/ListBookByCategoryId")
public class ListBookByCategoryId extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryId = request.getParameter("categoryId");
		System.out.println(categoryId);
		IBookService service = new BookServiceImpl();
		if(categoryId!=null) {
			int id = Integer.parseInt(categoryId);
			List<Book> list = service.getBooksByCategoryId(id);
			HttpSession session = request.getSession();
			session.setAttribute("books", list);
			response.sendRedirect(request.getContextPath()+"/list.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
