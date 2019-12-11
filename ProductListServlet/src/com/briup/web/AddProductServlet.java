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


@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBk");
		PrintWriter pw = response.getWriter();
		ProductService pros = new ProductServiceImpl();
		String name = request.getParameter("addname");
		double price = Double.parseDouble(request.getParameter("addprice"));
		String productor = request.getParameter("addproductor");
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setProductor(productor);
		if(pros.add(p)) {
			pw.println("添加成功");
		}else {
			pw.println("添加失败");
		}
		pw.println(name+" "+price+" "+productor);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
