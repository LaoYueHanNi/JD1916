package com.briup.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter{

	public FirstFilter() {
		System.out.println("this is filter constructor");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("this is filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("this is filter doFilter, before");
		//放行(把请求交给下一个filter
		//或者交给它真正需要的资源
		chain.doFilter(request, response); //
		
		System.out.println("this is filter doFilter, after");
	}

	@Override
	public void destroy() {
		System.out.println("this is filter destory");
	}
	
}
