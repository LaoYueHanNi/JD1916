package com.briup.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherS1
 */
@WebServlet("/path1")
public class DispatcherS1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("path111");
		
		//往request添加数据
		request.setAttribute("msg", "request message");
		
		
		//服务器的内部跳转
			//1)获取转发器的对象RequestDispatcher
				//1-1)从request中获取
				//RequestDispatcher rd = request.getRequestDispatcher("path2");
				//1-2)从ServletContext中获取
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/path2");
			//2)进行跳转
				rd.forward(request, response);//清空前一个的内容
				//rd.include(request, response);//不会清空前一个的信息
		
			//重定向跳转
			//response.sendRedirect("path2");
		pw.flush();
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
