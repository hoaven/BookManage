package com.kakanshun.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterSetFilter implements Filter {
	private FilterConfig filterConfig;
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String encodingValue = filterConfig.getInitParameter("encoding");//获取过滤器配置中的参数
		if(encodingValue==null) {   //如果没有配置该参数
			encodingValue="UTF-8";//给定默认值UTF-8
		}
		request.setCharacterEncoding(encodingValue);//只对POST请求方式有用  设置请求参数的编码
		response.setContentType("text/html;charset="+encodingValue);
		chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
}