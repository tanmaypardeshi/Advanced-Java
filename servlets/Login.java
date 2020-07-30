// A servlet for login page where in the fields like username, password, etc. can be populated by cookies

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet
{
    // this page is visited via link from index.html, override doGet()
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        pw.println("<html><body>");

        // declare 2 variables to hold the username and password which have arrived from cookie if it is present

        String un = "",pwd="";

        // read the cookie using getCookie(). If cookie does not exist it is typically when the user visits the website
        // for the first time or he/she is using a shared PC. However, if cookie is not available it throws
        // NullPointerException

        try
        {
            Cookie[] arr_cookie = req.getCookies();

            un = arr_cookie[0].getValue();
            pwd = arr_cookie[1].getValue();
        }
        catch (Exception e) { }

        // design the forms with details of user read from cookie on his machine. If there is no cookie, form fields
        // will remain empty

        pw.println("<form action='p6' method='post'>");
        pw.println("Username:- <input type='text' name='username' value= '" + un + "'<p>");
        pw.println("Password:- <input type='password' name='password' value= '" + pwd + "'<p>");
        pw.println("<input type='checkbox' name='rem' value='on'>Remember me on this machine?");
        pw.println("<input type='submit' value='Login'>");
        pw.println("</form></body></html>");
        pw.close();
    }
}

