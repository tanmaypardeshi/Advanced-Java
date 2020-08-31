// A server program which accept a series of filenames from client and sends their status to client

import java.net.*;
import java.io.*;

class Server_Files
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket ss = new ServerSocket(5002);
        Socket cs = ss.accept();

        // reserve buffer to accept all filenames sent by client as a single String using delimiter space

        BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));

        String filenames = fromclient.readLine();
        System.out.println(filenames);
        String arr_fns[] = filenames.split(" ");

        String contents = "";

        for (int i = 0; i < arr_fns.length; i++)
        {
            // wrap the filename into file object
            File f = new File(arr_fns[i]);
            if(f.exists())  //boolean
                contents += "File " + arr_fns[i] + " exists on the server\n";
            else
                contents += "File " + arr_fns[i] + " doesn't exists on the server\n";
            // dispatch the contents to client
        }
        PrintWriter toclient = new PrintWriter(cs.getOutputStream(), true);

        toclient.println(contents);

        toclient.close();
        fromclient.close();
        cs.close();
        ss.close();
    }
}