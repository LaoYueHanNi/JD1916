package com.briup.db;

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

import com.briup.common.ConnectionByJNDI;
import com.briup.common.ConnectionFactory;

/**
 * Servlet implementation class ListAllEmpServlet
 */
@WebServlet("/ListAllEmpServlet")
public class ListAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		PrintWriter pw = response.getWriter();
		//�����ݿ��ֲ�ѯ����Ա������Ϣ
		Connection conn = //ConnectionFactory.getConnection();
							ConnectionByJNDI.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			String sql = "select id,last_name,salary,title,start_date from s_emp";
			rs = st.executeQuery(sql);
			pw.println("<table border='1'>");
			pw.println("	<tr>\r\n" + 
					"		<th>���</th>\r\n" + 
					"		<th>����</th>\r\n" + 
					"		<th>����</th>\r\n" + 
					"		<th>ְ��</th>\r\n" + 
					"		<th>��ְʱ��</th>\r\n" +
					"<th> ����</th>"+
					"	</tr>\r\n");
					
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getInt("id")+"</td>"
						+"<td>"+rs.getString("last_name")+"</td>"
						+"<td>"+rs.getDouble("salary")+"</td>"
						+"<td>"+rs.getString("title")+"</td>"
						+"<td>"+rs.getDate("start_date")+"</td>"
						+"<td><input type='button' value='ɾ��'></td></tr>"
						);
			}
		pw.println("</table>");
		}catch(Exception e){
			e.printStackTrace();
		} 
		//��ʾ���������
		pw.flush();
		pw.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
