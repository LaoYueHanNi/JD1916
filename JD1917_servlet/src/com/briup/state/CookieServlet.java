package com.briup.state;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/Cookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		PrintWriter pw = response.getWriter();
		//3)从request获取cookie的数据(第一次访问没有cookie)
		Cookie[] cArray = request.getCookies();
		if(cArray!=null) {
			for(Cookie c:cArray) {
				String k=c.getName();
				String v=c.getValue();
				pw.println(k+"="+v);
			}
		}else {
			pw.println("当前没有cookie");
		}
		//1)创建coolkie(创建对象,用new)
			//以键值对方保存数据
			//只能保存字符串的数据
		Cookie c1 = new Cookie("name","briup"); 
		Cookie c2 = new Cookie("pwd","1243"); 
		//4)设置cookie的存活期,单位是秒
		c1.setMaxAge(60);
		c2.setMaxAge(60);
		//2)通过response讲cookie发送给客户端
		response.addCookie(c1);
		response.addCookie(c2);
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
