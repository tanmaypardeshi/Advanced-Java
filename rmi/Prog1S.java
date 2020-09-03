// Server program

import java.rmi.*;  // RemoteException class, Remote interface, Naming class
import java.rmi.server.*;   //UnicastRemoteObject class

public class Prog1S extends UnicastRemoteObject implements Prog1I
{
    // default constructor
    public Prog1S() throws RemoteException {}

    // override the abstract method of interface
    public String getMsg() throws RemoteException
    {
        // not compulsory
        System.out.println("Invocation of getMsg() on server successful");
        return "Welcome to RMI programming";
    }
    // create an object of server class and make it available to client through RMI registry
    public static void main(String[] args)
    {
        try
        {
            Prog1S obj = new Prog1S();
            Naming.rebind("refvar1", obj);
            System.out.println("Server object successfully bound to RMI Registry");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}