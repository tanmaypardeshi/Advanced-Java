// A servlet whic hwill write the cookie to a clients machine if he has requested to do so

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog6 extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        pw.println("<html><body>");

        String un = req.getParameter("username");
        String pwd = req.getParameter("password");
        String rem = req.getParameter("rem");

        // if rem is not selected and if you write if(rem.equals("on")) then this throws NullPointerException
        // Instead use the following

        if(rem != null)
        {
            // user is insisting to write personal info to the cookie
            Cookie c1 = new Cookie("username", un);
            Cookie c2 = new Cookie("password", pwd);

            // set the validity for cookie about a week

            c1.setMaxAge(604800);
            c2.setMaxAge(604800);

            // write the cookie into user's machine

            res.addCookie(c1);
            res.addCookie(c2);
        }
        pw.println("<h3> Welcome user " + un + " to our website</h3>");
        pw.close();
    }
}