// client program for chatting

import java.net.*;
import java.io.*;

public class Client_Chat
{
	public static void main(String[] args) throws IOException, UnknownHostException
	{
		Socket cs = new Socket("Predator", 5004);

		// reserve memory for communication with server
		BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		PrintWriter toserver = new PrintWriter(cs.getOutputStream(), true);

		// Once connected, the client sees a welcome message on his machine and he tens to respond and the conversation
		// begins

		while(true)
		{
			String s = fromserver.readLine();
			System.out.println("From server:- " + s);
			if(s.equalsIgnoreCase("bye"))
				break;
			System.out.print("From client:- ");

			String c = fromclient.readLine();
			toserver.println(c);
			if(c.equalsIgnoreCase("bye"))
				break;
		}
		toserver.close();
		fromserver.close();
		fromclient.close();
		cs.close();
	}
}
