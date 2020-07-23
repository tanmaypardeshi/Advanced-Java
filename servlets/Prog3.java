// Travel brochure using servlets
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog3 extends HttpServlet
{
    public void doPost(ServletRequest req, ServletResponse res) throws IOException, ServletException
    {
        res.getContentType("text/html");
        PrintWriter pw = res.getWriter();

        pw.println("<html><head><title>Your Travel Plans</title></head><body>");

        String cities = req.getParameterValues("city");

        pw.println("<h3> " + cities + "</h3>");
        pw.close();
    }
}
