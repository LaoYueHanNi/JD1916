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
				"		<span>�û��ǳ�</span><input type=\"text\"><br>\r\n" + 
				"		<span>�û�����</span><input type=\"password\"><br>\r\n" + 
				"		<span>�Ա�</span><input type=\"radio\" name=\"�Ա�\">��<input type=\"radio\" name=\"�Ա�\">Ů<br>\r\n" + 
				"		<span>����ʡ��</span><select name=\"ʡ��\">\r\n" + 
				"			<option>����</option>\r\n" + 
				"			<option>����</option>\r\n" + 
				"			<option>�㶫</option>\r\n" + 
				"			<option>����</option>\r\n" + 
				"		</select><br>\r\n" + 
				"		<span>����</span><textarea rows=\"10\" cols=\"50\"></textarea><br><br>\r\n" + 
				"		<span>��������</span><textarea rows=\"10\" cols=\"50\"></textarea>\r\n" + 
				"	</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		pw.flush();
		pw.close();
	}
	
}
