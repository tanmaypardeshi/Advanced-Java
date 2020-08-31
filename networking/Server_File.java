// A server program which accepts the name of the file from a client and defines its contents

import java.net.*;
import java.io.*;

class Server_File
{
    public static void main(String[] args) throws IOException
    {
        // reserve port on server to offer this service
        ServerSocket ss = new ServerSocket(5001);
        System.out.println("Server has reserved port number " + ss.getLocalPort() + " for this service");
        // socket object is created when client knocks to doors of server
        Socket cs = ss.accept();
        // not compulsory
        System.out.println("Client " + cs.getInetAddress() + " is communicating from port number " + cs.getPort());

        // the client has connected to the server and communicated the file name. Collect the filename from client.

        BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        String filename = fromclient.readLine();

        // collect the contents of file in String variable

        String contents = "";

        try
        {
            FileInputStream fin = new FileInputStream(filename);

            contents = "File found. Contents are:- \n";
            while(true)
            {
                int no = fin.read();    //returns ASCII code of character read
                if(no == -1)    //eof
                    break;
                contents += (char)no;
            }
            fin.close();
        }
        catch(FileNotFoundException e)
        {
            contents += "File " + filename + " doesn't exist on server";
        }
        // dispatch contents to client
        PrintWriter toclient = new PrintWriter(cs.getOutputStream(), true);
        toclient.println(contents);
        toclient.close();
        fromclient.close();
        cs.close();
        ss.close();
    }
}