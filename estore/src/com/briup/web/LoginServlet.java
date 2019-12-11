package com.briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.exception.CustomerException;
import com.briup.serviceImpl.CustomerServiceImpl;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		CustomerServiceImpl cus = new CustomerServiceImpl();
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		try{
			cus.login(name, pwd);
			session.setAttribute("name", name);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("LoginError", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
