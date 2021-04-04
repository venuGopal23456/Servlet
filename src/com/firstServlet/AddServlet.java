package com.firstServlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
@SuppressWarnings("serial")
public class AddServlet extends HttpServlet{
	
	//No Need to create Object for HttpServletRequest and HttpServletResponse,No need to create Object,Instead Tomcat will do that we just need to create Reference.
	//It is an Interface
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		//Send Data from one Servlet to Another use Session Management or setAttribute()
		//one k for Key and anothe for Value
//		req.setAttribute("k", k);
		
		//Two way to Make a call to another Servlet
		//1)Request Dispatcher 
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("sq");
//		requestDispatcher.forward(req, res);
		
		//2)Redirecting(Session Management - 2 concepts)
//		  	2a)URL Rewriting//it Fails for multiple Data
		//Telling the Browser to look for this Servlet from AddServlet
//		res.sendRedirect("sq?k=" + k);
		
//			2b)Session(Given by Tomcat,we need to just get the hold of it)
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("sq");
		
//			2c)Cookies
		//we cant pass cookie a int k it should be String for that append "" 
		Cookie cookie = new Cookie("k", k + "");
		res.addCookie(cookie);
		res.sendRedirect("sq");
		
		
		
	}

}
