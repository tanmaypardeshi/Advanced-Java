// A servlet which retrieves and displays page1 total calcultes page2 total and displays grand total

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog4b extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		pw.println("<html><body>");
		int sum = 0;	// running total of page 2

		// get all the values selected by the user

		String [] arr_vals = req.getParameterValues("items");

		if(arr_vals != null)
		{
			for (int i = 0; i < arr_vals.length; i++)
			{
				sum += Integer.parseInt(arr_vals[i]);
			}
		}
		//now retrieve total of page 1 from session object

		HttpSession s = req.getSession(false);

		//do not create a new session

		//return type of getAttribute() is is Object

		int sum_prev = Integer.parseInt(s.getAttribute("page1_ttl").toString());

		//display totals

		pw.println("<h2> Page 1 total is Rs. " + sum_prev + "<p>");
		pw.println("Page 2 total is Rs. " + sum + "<p>");
		pw.println("Grand total is Rs. " + sum + sum_prev + "<p>");
		pw.println("Session id is:- " + s.getId() + "</h2>");
		pw.println("</body></html");
		pw.close();
	}
}
