// A multi chat echo server. Here we need to maintain every client on a different thread

import java.net.*;
import java.io.*;

public class Multi_Chat_Server
{
	// resume a port on server
	ServerSocket ss = new ServerSocket(5004);
	// set an unique id for each client
	int id = 0;

	public static void main(String[] args) throws IOException
	{
		new Multi_Chat_Server();	//calling the constructor
	}
	Multi_Chat_Server() throws IOException
	{
		// new clients are continuously connecting to server and each needs to be identified by some unique ID
		while(true)
		{
			id++;
			// accept the request of client and create a reference to Socket object for communicating with him/her
			ClientThread ct = new ClientThread(ss.accept(), id);
			// create a seperate thread for each client
			Thread t = new Thread(ct);
			t.start();
		}
	}
}

class ClientThread implements Runnable
{
	Socket cs;
	int id;

	ClientThread(Socket cs, int id)
	{
		this.cs = cs;
		this.id = id;
	}
	public void run()
	{
		try
		{
			// reserve a buffer for every client
			BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintWriter toclient = new PrintWriter(cs.getOutputStream(), true);
			toclient.println("Welcome client " + id);
			while(true)
			{
				String c = fromclient.readLine();
				System.out.println("From client " + id + ":- " +c);
				if(c.contains("bye"))
					break;
				toclient.println(c);
			}
			System.out.println("Conversation with client " + id + " has been terminated");
			toclient.close();
			fromclient.close();
			cs.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
