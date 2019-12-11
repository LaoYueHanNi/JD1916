package com.briup.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Teacher;
import com.briup.exception.TeacherException;
import com.briup.service.ITeacherService;
import com.briup.service.TeacherServiceImpl;

@WebServlet("/LoginS")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1)����ҳ�洫�������� 
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name);
		System.out.println(pwd);
		//2)�����ݿ���֤�û������Ƿ���ȷ
		ITeacherService service = new TeacherServiceImpl();
		try {
			Teacher t = service.login(name, pwd);
			
			//��teacher�����ݱ��浽session��Χ
			HttpSession session = request.getSession();
			session.setAttribute("teacher", t);
			//3)���ݷ������صĲ�ͬ���,��ת����ͬ��ҳ��
			//��¼�ɹ�,��ת����ҳ��
			response.sendRedirect(request.getContextPath()+"/ListAllEmpServlet");
		} catch (TeacherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//��½ʧ��,��ת����¼ҳ��
			request.getRequestDispatcher("/login.html").forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
