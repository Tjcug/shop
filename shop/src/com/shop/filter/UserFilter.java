package com.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO 自动生成的方法存根
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		String servletPath=req.getServletPath();
		String queryPath=req.getQueryString();
		if(queryPath==null)
			queryPath="";
		String goURL=servletPath+"?"+queryPath;
		
		if(req.getSession().getAttribute("user")==null){
			req.getSession().setAttribute("error", "=.=请先登录");
			req.getSession().setAttribute("goURL", goURL);
			res.sendRedirect(req.getContextPath()+"/ulogin.jsp");
			System.out.println(goURL);
		}
		else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自动生成的方法存根
		
	}

}
