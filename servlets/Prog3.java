// am example of a servlet which is kept in a sub folder "tanmay" of "classes" and this servlet will process
// the multiple values sent via a html form

package tanmay;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog3 extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		pw.println("<html><head><title>Your report</title></head><body>");
		// now read values sent by the html element
		String []arr_dest = req.getParameterValues("city");

		// validation, rejection first
		if(arr_dest == null)
			pw.println("<h2>Please select at least one destination</h2>");
		else
		{
			int cost = 0;
			pw.println("<h2>Tour itinerary is</h2>");
			for(int i=0;i<arr_dest.length;i++)
			{
				if(arr_dest[i].equalsIgnoreCase("delhi"))
				{
					pw.println("<b>Delhi:- </b><br>");
					pw.println("<b>Stay:- <i>2 days @ <a href=''https://holidayinn.hotelsgroup.in/>Hotel Holiday Inn</a></i></b><br>");
					pw.println("<b>Places to visit:- <i>Qutub Minar, Red Fort, Sansad Bhavan</i></b><br>");
					cost += 2000;
				}
				else if(arr_dest[i].equalsIgnoreCase("agra"))
				{
					pw.println("<b>Agra:- </b><br>");
					pw.println("<b>Stay:- <i>2 days @ <a href='https://holidayinn.hotelsgroup.in/'>Hotel Holiday Inn</a></i></b><br>");
					pw.println("<b>Places to visit:- <i>Taj Mahal, Red Fort</i></b><br>");
					cost += 1000;
				}
				else if(arr_dest[i].equalsIgnoreCase("jaipur"))
				{
					pw.println("<b>Jaipur:- </b><br>");
					pw.println("<b>Stay:- <i>2 days @ <a href='https://holidayinn.hotelsgroup.in/'>Hotel Holiday Inn</a></i></b><br>");
					pw.println("<b>Places to visit:- <i>Some place</i></b><br>");
					cost += 1500;
				}
				else
				{
					pw.println("<b>Amritsar:- </b><br>");
					pw.println("<b>Stay:- <i>2 days @ <a href='https://holidayinn.hotelsgroup.in/'>Hotel Holiday Inn</a></i></b><br>");
					pw.println("<b>Places to visit:- <i>Some place</i></b><br>");
					cost += 2000;
				}
			}
			pw.println("<h3>Total cost is:- " + cost + "</h3>");
		}
		pw.println("</body></html>");
		pw.close();
	}
}
