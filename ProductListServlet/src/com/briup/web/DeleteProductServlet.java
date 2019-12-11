package com.briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.service.ProductService;
import com.briup.service.ProductServiceImpl;


@WebServlet("/Delete")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		ProductService pros = new ProductServiceImpl();
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("proname");
		if(pros.delete(name)) {
			pw.println("É¾³ý³É¹¦");
		}else {
			pw.println("É¾³ýÊ§°Ü");
		}
		
		pw.flush();
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
