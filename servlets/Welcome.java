// Welcome servlet with base application features
// If user overstays here for more than a minute, we need to expire the links of
// thus page to avoid account to  be misued

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Welcome extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// if this servlet is visited via a link or sendRedirect() then we have to override doGet()

		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();

		pw.println("<html><body>");

		// retrieve the session for user. If visit to this page is direct by using the URL from history of browser,then
		// as session object on server is already destroyed during log out, retrieving session will result in NullPointerException

		try
		{
			HttpSession s = req.getSession(false);

			pw.println("<h3> Welcome " + s.getAttribute("username") + "</h3>");
			pw.println("<b> Facilities available:- </b><p>");
			pw.println("<a href='bb'> Check bank balance </a><p>");
			s.setMaxInactiveInterval(60);		//60 seconds i.e. 1 min
		}
		catch (NullPointerException e)
		{
			resp.sendRedirect("nologin.html");
		}
		pw.println("</body></html>");
		pw.close();
	}
}
