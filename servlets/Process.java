// pure processing servlet i.e. this servlet will not produce any output

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Process extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// do not use res.ContentType() because this servlet will not send any output to client

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "java1234!");

			String sql = "select * from accounts where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				// valid useranme with password - authenticated
				// create a session for the user

				HttpSession s = req.getSession(true);
				s.setAttribute("username", username);
				s.setAttribute("balance", new Integer(rs.getInt(3)));

				// redirect the user to the welcome page

				resp.sendRedirect("welcome");	//welcome is URL pattern

				//Welcome.class servlet
			}
			else
				resp.sendRedirect("nologin.html");

			rs.close();
			ps.close();
			conn.close();
		}
		catch (Exception e)
		{
			PrintWriter pw = resp.getWriter();
			pw.println("<html><body><h2>" + e.getMessage() + "</h2></body></html>");
			pw.close();
			System.out.println(e.getMessage());
		}
	}
}
