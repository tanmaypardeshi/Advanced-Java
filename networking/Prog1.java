// to display ip address on our machine

import java.net.*;

class Prog1
{
	public static void main(String[] args) throws UnknownHostException
	{
		InetAddress ip = InetAddress.getLocalHost();
		String name = ip.getHostName();
		String add = ip.getHostAddress();

		System.out.println("Host name is:- " + name);
		System.out.println("Host address is:- " + add);
	}
}