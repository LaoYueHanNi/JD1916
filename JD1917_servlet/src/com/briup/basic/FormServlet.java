package com.briup.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormServlet extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServerException {
		response.setCharacterEncoding("GBK");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"GBK\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<form action=\"\">\r\n" + 
				"		<span>用户昵称</span><input type=\"text\"><br>\r\n" + 
				"		<span>用户密码</span><input type=\"password\"><br>\r\n" + 
				"		<span>性别</span><input type=\"radio\" name=\"性别\">男<input type=\"radio\" name=\"性别\">女<br>\r\n" + 
				"		<span>所在省份</span><select name=\"省份\">\r\n" + 
				"			<option>江西</option>\r\n" + 
				"			<option>广西</option>\r\n" + 
				"			<option>广东</option>\r\n" + 
				"			<option>江苏</option>\r\n" + 
				"		</select><br>\r\n" + 
				"		<span>爱好</span><textarea rows=\"10\" cols=\"50\"></textarea><br><br>\r\n" + 
				"		<span>个人评价</span><textarea rows=\"10\" cols=\"50\"></textarea>\r\n" + 
				"	</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		pw.flush();
		pw.close();
	}
	
}
