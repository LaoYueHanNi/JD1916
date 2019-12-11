package com.briup.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecondFilter
 */
@WebFilter("/*")
public class SecondFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		long start = System.currentTimeMillis();
		System.out.println("second Filter doFilter before");
		chain.doFilter(req, res);
		long end = System.currentTimeMillis();
		System.out.println("second Filter doFilter after");
		System.out.println("访问"+req.getServletPath()+"消耗时间:"+(end-start));
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
