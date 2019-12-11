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
		
		//��request�������
		request.setAttribute("msg", "request message");
		
		
		//���������ڲ���ת
			//1)��ȡת�����Ķ���RequestDispatcher
				//1-1)��request�л�ȡ
				//RequestDispatcher rd = request.getRequestDispatcher("path2");
				//1-2)��ServletContext�л�ȡ
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/path2");
			//2)������ת
				rd.forward(request, response);//���ǰһ��������
				//rd.include(request, response);//�������ǰһ������Ϣ
		
			//�ض�����ת
			//response.sendRedirect("path2");
		pw.flush();
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
