package com.briup.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServerException {
		response.setCharacterEncoding("GBK");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>hello ÀÏÔ¼º²ÄÝ</h1>");
		pw.flush();
		pw.close();
	}
	
}
