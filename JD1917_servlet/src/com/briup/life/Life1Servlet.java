package com.briup.life;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Life1Servlet implements Servlet {

	public Life1Servlet() {
		//System.out.println("life1 gouzao");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
//		System.out.println("ini init");
//		// ȡ�ֲ�����
//		String v = config.getInitParameter("name");
//		System.out.println("life1 name:" + v);
//		String a = config.getInitParameter("age");
//		System.out.println("life1 age:" + a);
//
//		// ȡȫ�ֲ���
//		ServletContext sc = config.getServletContext();
//		String m = sc.getInitParameter("msg");
//		System.out.println("life1 msg:" + m);

		// ȥ���в�����ô�ŵ�Enumeration
		Enumeration<String> en = config.getInitParameterNames();
	}

	@Override
	// ������
	public ServletConfig getServletConfig() {
		//System.out.println("life1 config");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//System.out.println("life1 gouzao");
	}

	@Override
	public String getServletInfo() {
		System.out.println("life1 info");
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("life1 destory");
	}

}
