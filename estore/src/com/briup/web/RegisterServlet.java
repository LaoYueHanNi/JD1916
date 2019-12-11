package com.briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.exception.CustomerException;
import com.briup.serviceImpl.CustomerServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		PrintWriter pw = response.getWriter();
		CustomerServiceImpl cus = new CustomerServiceImpl();
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String zip = request.getParameter("zipCode");
		String phone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Customer customer = new Customer(name, pwd, zip, "双港江西理工", phone, email);
		try {
			cus.register(customer);
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} catch (CustomerException e) {
			e.printStackTrace();
			request.setAttribute("RegisterError", e.getMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
