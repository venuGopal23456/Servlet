package com.firstServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@SuppressWarnings("serial")
@WebServlet("/sq")
public class SquareServlet extends HttpServlet   {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		//For ReqestDispatcher
//		int k  = (int) req.getAttribute("k");
		
		//For Redirecting to get the Obj
		//If we pass the ?k=9 in the sq url this will work if we dont pass in the previous Servlet
//		int k = Integer.parseInt(req.getParameter("k"));
		
		//Using Seesion to get the Value
		
		HttpSession session = req.getSession();
		//when we dont need value we can remove this k which will throw NPE
		  //session.removeAttribute("k");
//		int k = (int) session.getAttribute("k");
//		
//		k = k * k;
//		PrintWriter outPrintWriter = res.getWriter();
//		outPrintWriter.println("The is My page " + k);
		
		//Using cookie to get the Value
		int k = 0;
		Cookie cookies[] = req.getCookies();
		
		for(Cookie c : cookies)
		{
			if(c.getName().equals("k"))
			{
				k = Integer.parseInt(c.getValue());
			}
		}
		k = k * k;
		PrintWriter outPrintWriter = res.getWriter();
		outPrintWriter.println("<html><body bgcolor = 'Blue'>");
		outPrintWriter.println("The is My page " + k);
		outPrintWriter.println("</body></html>");
		
	}

}
