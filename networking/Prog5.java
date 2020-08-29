// an eg. of web scraping i.e. to read the contents of a website

import java.net.*;
import java.util.Scanner;
import java.io.*;

class Prog5
{
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter URL of website:- ");
		String url = sc.next();
		// create URL object
		URL url_obj = new URL(url);
		URLConnection urlc = url_obj.openConnection();
		int len = urlc.getContentLength();

		if(len == 0)
		{
			System.out.println("Resource not found!");
		}
		else
		{
			System.out.println("Length of content is:- " + len);
			System.out.println("Date and time of scraping is:- " + new java.util.Date(urlc.getDate()));
			// get the contents of website in console
			InputStream is = urlc.getInputStream();
			while (true)
			{
				int no = is.read();
				if(no == -1)	//end of stream
					break;
				System.out.print((char)no);
			}
		}
	}
}