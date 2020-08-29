// to display ip address of machine if iys name is known

import java.net.*;

class Prog2
{
    public static void main(String[] args) throws UnknownHostException
    {
        InetAddress ipadr = InetAddress.getByName("Predator");
        String adr = ipadr.getHostAddress();

        System.out.println("IP address of given machine is:- " + adr);
    }
}