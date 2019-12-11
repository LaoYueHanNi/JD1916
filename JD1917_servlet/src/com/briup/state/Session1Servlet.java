package com.briup.state;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session1Servlet
 */
@WebServlet("/session1")
public class Session1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		//2)从cookie种获取session'的id值
		Cookie[] cs = request.getCookies();
		if(cs!=null) {
			for(Cookie c:cs) {
				pw.println(c.getName()+"="+c.getValue());
			}
		}
		
		//1 )创建session
		HttpSession session = request.getSession();
		pw.println("id:"+session.getId());
		
		//3)往session种保存数据
		session.setAttribute("msg", "this is session mesage");
		request.setAttribute("msg", "this is request mesage");
		//从request中取数据
		Object obj1 =request.getAttribute("msg");
		pw.println(obj1);
		//往application中保存数据
		ServletContext sc = getServletContext();
		sc.setAttribute("msg", "this is application mesage");
		
		//4)从session中取数据
		Object obj  = session.getAttribute("msg");
		pw.println(obj);
		
		//立即销毁session对象
		//session.invalidate();
		
		response.sendRedirect(request.getContextPath()+"/session2");
		
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
