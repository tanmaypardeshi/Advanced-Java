// A server program to chat with a single client @ a time and the conversation should continue
// till either of them says "bye"

import java.io.*;
import java.net.*;


public class Server_Chat
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(5003);
		Socket cs = ss.accept();

		//reserve memory on server for sending and receiving messages
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		PrintWriter toclient = new PrintWriter(cs.getOutputStream(), true);

		// the client has communicated, so send a welcome message to him

		toclient.println("Welcome Client for chat program");

		// now the conversation begins
		while(true)
		{
			// accept the message sent by client
			String c = fromclient.readLine();
			System.out.println("From client:- " + c);
			// check the message
			if(c.equalsIgnoreCase("bye"))
				break;
			// now server responds
			System.out.print("Server:- ");
			String s = fromserver.readLine();
			toclient.println(s);
			if(s.equalsIgnoreCase("bye"))
				break;
		}
		toclient.close();
		fromclient.close();
		fromserver.close();
		cs.close();
		ss.close();
	}
}
