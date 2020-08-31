// Client program sending a couple of filenames to server to check for their presence on server

import java.net.*;
import java.io.*;

class Client_Files
{
    public static void main(String[] args) throws IOException, UnknownHostException
    {
        Socket cs = new Socket("LAPTOP-GA8C0AII", 5002);
        System.out.print("Enter filename seperated by space:- ");

        BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));

        String filenames = fromclient.readLine();

        // send these filenames to server

        PrintWriter toserver = new PrintWriter(cs.getOutputStream(), true);

        toserver.println(filenames);

        // client will expect a response from server

        BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        System.out.println("Response from server is");

        while(true)
        {
            String line = fromserver.readLine();
            if(line == null)
                break;
            System.out.println(line);
        }

        fromserver.close();
        toserver.close();
        fromclient.close();
        cs.close();
    }
}