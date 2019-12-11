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

@WebServlet("/UpdateProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBk");
		PrintWriter pw = response.getWriter();
		ProductService pros = new ProductServiceImpl();
		String name = request.getParameter("updatename");
		double price = Double.parseDouble(request.getParameter("updatprice"));
		String productor = request.getParameter("updateproductor");
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setProductor(productor);
		if(pros.update(p)) {
			pw.println("修改成功");
		}else {
			pw.println("修改失败,无此用户");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
