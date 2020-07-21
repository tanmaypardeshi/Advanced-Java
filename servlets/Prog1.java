// First servlet to greet the user depending upon the time of the day

import java.io.*;	//PrintWriter, IOException
// PrintWriter will deliver the output stream to the client in html


import javax.servlet.*;	//GenericServlet and ServletException and also ServletRequest and ServletResponse interfaces

import java.util.GregorianCalendar;
// Date class from previous jdk version is deprecated

// all servlet classes should be declared public as they are executed by some external programs like Tomcat(Web Server/
// Container)

public class Prog1 extends GenericServlet
{
	// Override the service() and specify the action to be taken on user's request
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		//set the MIME type of contents
		res.setContentType("text/html");

		//create an object to deliverhtml
		PrintWriter pw = res.getWriter();

		//PrintWriter object will dispatch the o/p stream through the response object

		//html can be generated using println method of PrintWriter object
		pw.println("<html><head><title>Servlet Program</title></head><body>");

		//get the current time on server
		GregorianCalendar gcal = new GregorianCalendar();

		int hrs = gcal.get(GregorianCalendar.HOUR_OF_DAY);
		//returns the time in 24 hour format

		String wish = "Good ";

		if(hrs < 12)
			wish += "Morning";
		else if(hrs < 17)
			wish += "Afternoon";
		else
			wish += "Evening";

		pw.println("<h2> " + wish +  "</h2>");
		pw.println("</body></html>");

		pw.close();
	}
}
