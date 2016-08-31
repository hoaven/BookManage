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
		String encodingValue = filterConfig.getInitParameter("encoding");//��ȡ�����������еĲ���
		if(encodingValue==null) {   //���û�����øò���
			encodingValue="UTF-8";//����Ĭ��ֵUTF-8
		}
		request.setCharacterEncoding(encodingValue);//ֻ��POST����ʽ����  ������������ı���
		response.setContentType("text/html;charset="+encodingValue);
		chain.doFilter(request, response);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
}