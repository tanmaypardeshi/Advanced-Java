// Client Program to get Date of server

import java.net.*;
import java.io.*;

public class Client_Dt
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		// create a client socket to connect to server
		Socket cs = new Socket("Predator", 5000);
		// once connectedm the server will immediately dispatch the message because it knows who has communicated to
		// confirm, not compulsory
		System.out.println("Client is communicating from port number " + cs.getLocalPort());
		// collect the data sent by server in client's buffer
		BufferedReader from_server = new BufferedReader(new InputStreamReader((cs.getInputStream())));
		// we refer BufferedReader because it is efficient with readLine()
		String msg = from_server.readLine();
		System.out.println(msg);
		from_server.close();
		cs.close();
	}
}
