// an eg. of important methods of URL class

import java.net.*;

class Prog4
{
    public static void main(String[] args) throws MalformedURLException
    {
        String url = "http://www.microsoft.com:8080/products.html";

        URL url_adr = new URL(url); //url object
        System.out.println("Protocol used is:- " + url_adr.getProtocol());
        System.out.println("Host is:- " + url_adr.getHost());
        System.out.println("Port used is:- " + url_adr.getPort());
        System.out.println("Resource is:- " + url_adr.getFile());
    }
}