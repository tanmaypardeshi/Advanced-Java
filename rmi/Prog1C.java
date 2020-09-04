// Client class

import java.rmi.*;

public class Prog1C
{
    public static void main(String[] args)
    {
        try
        {
            // obtain a reference to the server object on remote machine from RMI registry using interface
            Prog1I obj = (Prog1I)Naming.lookup("rmi://localhost:5002/refvar1");
            System.out.println("Message from server is " + obj.getMsg());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}