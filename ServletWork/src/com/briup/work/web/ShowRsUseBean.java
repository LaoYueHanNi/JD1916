package com.briup.work.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.work.dao.DBTest;

/**
 * Servlet implementation class ShowRsUseBean
 */
@WebServlet("/ShowRsUseBean")
public class ShowRsUseBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		PrintWriter pw = response.getWriter();
		try {
			conn = DBTest.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from jd_user";
			ResultSet rs = statement.executeQuery(sql);
			pw.println("<table border='1'>");
			pw.println("	<tr>\r\n" + 
					"		<th>编号</th>\r\n" + 
					"		<th>姓名</th>\r\n" + 
					"		<th>密码</th>\r\n" + 
					"		<th>性别</th>\r\n" + 
					"		<th>年龄</th>\r\n" +
					"		<th>爱好</th>\r\n" +
					"		<th>城市</th>\r\n" +
					"<th> 宣言</th>"+
					"	</tr>\r\n");
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getInt("id")+"</td>"
						+"<td>"+rs.getString("username")+"</td>"
						+"<td>"+rs.getString("password")+"</td>"
						+"<td>"+rs.getString("gender")+"</td>"
						+"<td>"+rs.getInt("age")+"</td>"
						+"<td>"+rs.getString("hobby")+"</td>"
						+"<td>"+rs.getString("city")+"</td>"
						+"<td>"+rs.getString("motto")+"</td>"
						+"</tr>"
						);
			}
			pw.println("</table>");
			pw.flush();
			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
