package com.firstServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		//Servlet Context - For Many Servlet only one Instance is Created by Tomcat
		//Shared Multiple Values go with this
//		PrintWriter printWriter = res.getWriter();
//		printWriter.print("Hi <br/>");
//		
//		ServletContext context = getServletContext();
//		String out = context.getInitParameter("name");
//		printWriter.println(out);
		
		
		//Servlet Config - For 2 Servlet two instance can be Created by Tomcat
		//Unique Value for Different Servlet go with this
		PrintWriter printWriter = res.getWriter();
		printWriter.print("Hi");
		
		ServletConfig config = getServletConfig();
		String out = config.getInitParameter("Beauty");
		printWriter.println(out);
		
	}

}
