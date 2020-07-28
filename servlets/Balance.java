// A servlet to display bank balance of customer

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Balance extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// if this servlet is visited via a link or sendRedirect() then we have to override doGet()

		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();

		//this page should not  be stored in cache as it contains sensitive information
		resp.setHeader("pragma", "no-cache");
		resp.setHeader("cache-control", "no-store");

		pw.println("<html><body>");

		// retrieve the session for user. If visit to this page is direct by using the URL from history of browser,then
		// as session object on server is already estroyed during log out, retirieving session will result in NullPointerException

		try
		{
			HttpSession s = req.getSession(false);

			pw.println("<h3> Welcome " + s.getAttribute("username") + "</h3>");
			pw.println("<h3>Your bank balance is Rs. " + s.getAttribute("balance") + "</h3>");
			pw.println("<form action='lo' method='post'>");
			pw.println("<input type='submit' value='Logout'>");
			pw.println("</form>");
		}

		catch (NullPointerException e)
		{
			resp.sendRedirect("nologin.html");
		}
		pw.println("</body></html>");
		pw.close();
	}
}
