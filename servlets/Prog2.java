// a servlet which accept the data of a form and

import java.io.*;
import javax.servlet.*;
import  javax.servlet.http.*;	// class - HttpServlet, interface - HttpServletResponse, HttpServletRequest

public class Prog2 extends HttpServlet
{
	// because html form accepting data from user contains values "post" in attribute "method", use doPost() method
	// of HttpServlet which informally calls the service method

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		pw.println("<html><body>");

		// now we need to get the value of html paramter "color" from form

		String colourname = req.getParameter("colour");

		pw.println("<h2><font color ='" + colourname + "'> It seems your favourite colour is " + colourname + "</font></h2>");
		pw.println("</body></html>");
		pw.close();
	}
}