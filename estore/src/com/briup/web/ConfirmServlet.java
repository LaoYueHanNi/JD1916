package com.briup.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.Order;
import com.briup.bean.OrderLine;
import com.briup.bean.ShoppingCar;
import com.briup.exception.CustomerException;
import com.briup.service.ICustomerService;
import com.briup.service.IOrderService;
import com.briup.serviceImpl.CustomerServiceImpl;
import com.briup.serviceImpl.OrderServiceImpl;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		IOrderService service = new OrderServiceImpl();
		ICustomerService cService = new CustomerServiceImpl();
		
		Order order = new Order();
		Customer customer = new Customer();
		String name = (String) session.getAttribute("name");
		ShoppingCar car = (ShoppingCar) session.getAttribute("shoppingCar");
		
		try {
			customer = cService.findCustomerByName(name);
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		order.setOrderDate(new Date());
		order.setCost(car.getCost());// ×Ü¼ÛÇ®
		order.setCustomer(customer);
		List<OrderLine> orderLines = new ArrayList<>();
		for (OrderLine line : car.getLines().values()) {
			line.setOrder(order);
			line.setCost(line.getNum() * line.getBook().getPrice());
			orderLines.add(line);
		} 
		order.setOrderLines(orderLines);
		service.saveOrder(order);
		response.sendRedirect(request.getContextPath()+"/OrderListServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
