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
		//3)��request��ȡcookie������(��һ�η���û��cookie)
		Cookie[] cArray = request.getCookies();
		if(cArray!=null) {
			for(Cookie c:cArray) {
				String k=c.getName();
				String v=c.getValue();
				pw.println(k+"="+v);
			}
		}else {
			pw.println("��ǰû��cookie");
		}
		//1)����coolkie(��������,��new)
			//�Լ�ֵ�Է���������
			//ֻ�ܱ����ַ���������
		Cookie c1 = new Cookie("name","briup"); 
		Cookie c2 = new Cookie("pwd","1243"); 
		//4)����cookie�Ĵ����,��λ����
		c1.setMaxAge(60);
		c2.setMaxAge(60);
		//2)ͨ��response��cookie���͸��ͻ���
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