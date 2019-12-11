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
		//获取bookid,num的值
		HttpSession session = request.getSession();
		IBookService service = new BookServiceImpl();
		String bookId = request.getParameter("bookId");
		String num = request.getParameter("num");
		int id = Integer.parseInt(bookId);
		int n  = Integer.parseInt(num);
		Book book = service.getBookByBookId(id);
		//调用购物车对象的add方法addShoppingCar
			//从session对象取出来
		ShoppingCar car = (ShoppingCar) session.getAttribute("shoppingCar");
		OrderLine  orderLine = new OrderLine();
		orderLine.setBook(book);
		orderLine.setNum(n);
		//3)调用购物车对象的add方法
			//封装OrderLine对象
		car.add(orderLine);
		//System.out.println(car);
		session.setAttribute("sCar", car);
		response.sendRedirect(request.getContextPath()+"/shopCart.jsp");
		//4)跳转到shopCart.jsp页面
			//显示当前购物车物品的信息
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
