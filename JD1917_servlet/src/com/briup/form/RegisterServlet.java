package com.briup.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.setCharacterEncoding("GBK");

		//1)接受客户端发送的数据
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("userName");
		System.out.println(name);
		pw.println("名字:"+name);
		String pwd = request.getParameter("userPwd");
		System.out.println(pwd);
		pw.println(pwd);
		String gender = request.getParameter("gender");
		System.out.println(gender);
		pw.println(gender);
		String[] hs = request.getParameterValues("hobby");
		StringBuilder sb = new StringBuilder();
		for(String temp: hs) {
			sb.append(temp+",");
		}
		pw.println("爱好"+sb.toString());
		
		//到数据库操作
		
		//跳转
		if(name!=null) {
			//注册成功
		}else{
			//注册失败!跳转到注册界面
		}
		
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
