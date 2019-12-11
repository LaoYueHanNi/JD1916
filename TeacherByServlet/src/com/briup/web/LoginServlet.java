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
		//1)接受页面传来的数据 
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name);
		System.out.println(pwd);
		//2)到数据库验证用户密码是否正确
		ITeacherService service = new TeacherServiceImpl();
		try {
			Teacher t = service.login(name, pwd);
			
			//把teacher的数据保存到session范围
			HttpSession session = request.getSession();
			session.setAttribute("teacher", t);
			//3)根据方法返回的不同情况,跳转到不同的页面
			//登录成功,跳转到主页面
			response.sendRedirect(request.getContextPath()+"/ListAllEmpServlet");
		} catch (TeacherException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//登陆失败,跳转到登录页面
			request.getRequestDispatcher("/login.html").forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
