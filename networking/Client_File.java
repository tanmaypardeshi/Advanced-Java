// Client program which connects to a server and sends the filename

import java.net.*;
import java.io.*;

class Client_File
{
    public static void main(String[] args) throws IOException, UnknownHostException
    {
        // create a client socket for birdirectional communication
        Socket cs = new Socket("LAPTOP-GA8C0AII", 5001);

        // to confirm
        System.out.println("Client is communicating from port " + cs.getLocalPort());

        // reserve a buffer to store a filename to be sent to the server
        System.out.print("Enter a filename to read:- ");
        BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));

        String filename = fromclient.readLine();

        // send/dispatch the filename to server

        PrintWriter toserver = new PrintWriter(cs.getOutputStream(), true);

        toserver.println(filename);

        // now the client will expect a packet of contents from the server
        BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        // now read the buffer "from server" line by line till the end

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