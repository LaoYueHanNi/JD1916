package com.briup.life;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Life2Servlet implements Servlet{

	public Life2Servlet() {
		//System.out.println("life2 gouzao");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("ini init");
	}

	@Override
	public ServletConfig getServletConfig() {
		//System.out.println("life2 config");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	//	System.out.println("life2 gouzao");
	}

	@Override
	public String getServletInfo() {
	//	System.out.println("life2 info");
		return null;
	}

	@Override
	public void destroy() {
		//System.out.println("life destory");
	}

}
