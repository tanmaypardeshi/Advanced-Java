// A server program which sends the current date and time of server to its client

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.PrimitiveIterator;

class Server_Dt
{
	public static void main(String[] args) throws IOException
	{
		// reserve a port for this service on server
		ServerSocket ss = new ServerSocket(5000);
		// to confirm - not compulsory
		System.out.println("Server as reserve port number:- " + ss.getLocalPort() + " for this service");
		// create a socket object to connect to a client
		Socket cs = ss.accept();
		// to confirm the arrival of client, not compulsory
		System.out.println("Client " + cs.getInetAddress() + " is communicating from port number " + cs.getPort());
		// create a Date object
		Date d = new Date();
		String msg = "Cureent data and time on server is " + d.toString();
		// generate o/p stream through client socket
		PrintWriter toclient = new PrintWriter(cs.getOutputStream(), true);
		// the 2nd parameter is "flush the buffer?". If set to truem the o/p dispatched immediately to the client
		// and if set to false, will get created in server's buffer and can be sent later using toClient.flush() at once

		toclient.println(msg);
		toclient.close();
		cs.close();
		ss.close();
	}
}