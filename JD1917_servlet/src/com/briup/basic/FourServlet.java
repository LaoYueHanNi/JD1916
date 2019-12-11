package com.briup.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现servlet的第三种方法
@WebServlet("/four")
public class FourServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String m = req.getMethod();
		System.out.println(m);
		String p1 = req.getContextPath();
		System.out.println(p1);
		String p2 = req.getServletPath();
		System.out.println(p2);
		int p3 = req.getServerPort();
		System.out.println(p3);
		String p4 = req.getRequestURI();
		System.out.println(p4);
		String p5 = req.getRealPath("image/bear.png");
		System.out.println(p5);
	}
}
