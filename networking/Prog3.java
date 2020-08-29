// to display all ip addresses for a single domain

import java.net.*;

class Prog3
{
    public static void main(String[] args) throws UnknownHostException
    {
        // get domain name as command line argument

        InetAddress ipadrs[] = InetAddress.getAllByName(args[0]);

        System.out.println("Domain name and IP address are:- ");
        for (int i = 0; i < ipadrs.length; i++)
        {
            System.out.println(ipadrs[i]);  //if getHostNmae() and getHostAddress are not used, we get both
        }
    }
}