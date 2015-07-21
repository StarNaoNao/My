package com.filterTest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest implements Filter {

	private String age;
	
	@Override
	public void destroy() {
		System.out.println("filter销毁中...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("拦截器 begin");
		// 设置字符集
		request.setAttribute("age", age);
		
		//继续向下执行，如果还有其他filter继续调用其他filter，没有的话将消息发送给服务器或客户端
		chain.doFilter(request, response);
		System.out.println("拦截器 end");
		
//		//控制用户访问权限
//		HttpServletRequest req=(HttpServletRequest)request;
//		HttpServletResponse res=(HttpServletResponse)response;
//		HttpSession session=req.getSession();
//
//		if(session.getAttribute("user_info")!=null){
//			chain.doFilter(request, response);
//		}else{
//			res.sendRedirect(req.getContextPath()+"/error.html");
//		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter初始化...");
		age=filterConfig.getInitParameter("age");
		System.out.println("年龄是："+age);
	}

}
