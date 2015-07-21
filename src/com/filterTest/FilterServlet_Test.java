package com.filterTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterServlet_Test extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String b = "cunzai";
		if(b.equals("cunzai")){
			String result="no";
			request.setAttribute("result", result);
			//使用servlet的dispatcher可以跳转到web-inf下的jsp页面。直接在html页面中是无法访问web-inf下页面的
			request.getRequestDispatcher("/WEB-INF/views/Filter_success.jsp").forward(request, response);//路径注意斜杠
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}
