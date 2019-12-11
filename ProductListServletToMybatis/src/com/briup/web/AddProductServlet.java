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
		if(name!=""&&name!=null) {
			if(pros.add(p)) {
				pw.println("��ӳɹ�");
			}else {
				pw.println("���ʧ��");
			}
			pw.println(name+" "+price+" "+productor);
		}else {
			pw.println("���ֲ���Ϊ��");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
