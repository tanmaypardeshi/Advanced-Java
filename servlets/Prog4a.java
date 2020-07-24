// A servlet which accepts the values of items, display page1 total and stores it in session for every user and displays
// more items in sale

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog4a extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		pw.println("<html><body>");

		int sum = 0;	//returning total
		// get the values of items selected by user

		String [] arr_vals = req.getParameterValues("items");

		if(arr_vals!=null)
		{
			for (int i = 0; i < arr_vals.length; i++)
			{
				sum += Integer.parseInt(arr_vals[i]);
			}
		}

		//create a session for the user and store his total in a session object

		HttpSession s = req.getSession(true);

		s.setAttribute("page_ttl", new Integer(sum));

		//String name, Object value

		//display contents

		pw.println("<h3>Page 1 total is Rs. " + sum + "</h3>");
		pw.println("<form action='p4b' method='post'>");
		pw.println("<b>Select the items to purchase</b><p>");
		pw.println("<input type='checkbox' name='items' value='100'>Compass box @ Rs. 100/- </p>");
		pw.println("<input type='checkbox' name='items' value='150'>Colour box @ Rs. 150/- </p>");
		pw.println("<input type='submit' value='Next>>'><p>");

		pw.println("</form></body></html>");
		pw.close();
	}
}
