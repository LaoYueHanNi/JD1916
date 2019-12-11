package com.briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Book;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCar;
import com.briup.service.IBookService;
import com.briup.serviceImpl.BookServiceImpl;

/**
 * Servlet implementation class addShoppingCar
 */
@WebServlet("/addShoppingCar")
public class addShoppingCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡbookid,num��ֵ
		HttpSession session = request.getSession();
		IBookService service = new BookServiceImpl();
		String bookId = request.getParameter("bookId");
		String num = request.getParameter("num");
		int id = Integer.parseInt(bookId);
		int n  = Integer.parseInt(num);
		Book book = service.getBookByBookId(id);
		//���ù��ﳵ�����add����addShoppingCar
			//��session����ȡ����
		ShoppingCar car = (ShoppingCar) session.getAttribute("shoppingCar");
		OrderLine  orderLine = new OrderLine();
		orderLine.setBook(book);
		orderLine.setNum(n);
		//3)���ù��ﳵ�����add����
			//��װOrderLine����
		car.add(orderLine);
		//System.out.println(car);
		session.setAttribute("sCar", car);
		response.sendRedirect(request.getContextPath()+"/shopCart.jsp");
		//4)��ת��shopCart.jspҳ��
			//��ʾ��ǰ���ﳵ��Ʒ����Ϣ
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
