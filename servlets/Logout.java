// Logout servlet

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// if this servlet is visited via a link or sendRedirect() then we have to override doGet()

		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();

		pw.println("<html><body>");

		// retrieve the session for user. If visit to this page is direct by using the URL from history of browser,then
		// as session object on server is already estroyed during log out, retirieving session will result in NullPointerException

		try
		{
			HttpSession s = req.getSession(false);

			pw.println("<h3>You have been logged out successfully!</h3>");

			s.invalidate();	//destroy session
		}
		catch (NullPointerException e)
		{
			resp.sendRedirect("nologin.html");
		}
		pw.println("</body></html>");
		pw.close();
	}
}

