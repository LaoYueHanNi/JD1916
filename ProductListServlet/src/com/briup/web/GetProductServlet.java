package com.briup.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Product;
import com.briup.service.ProductService;
import com.briup.service.ProductServiceImpl;


@WebServlet("/GetProduct")
public class GetProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService pros = new ProductServiceImpl();
		response.setCharacterEncoding("GBK");
		String name = request.getParameter("selectname");
		PrintWriter pw = response.getWriter();
		
		Product p = pros.Get(name);
		if(p==null) {
			pw.println("无此用户");
		}else {
			pw.println("id="+p.getId());
			pw.println("name="+p.getName());
			pw.println("price"+p.getPrice());
			pw.println("productor="+p.getProductor());
			
		}
		
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
