// Server program for GUI application

import java.rmi.*;
import java.rmi.server.*;

public class Prog2S extends UnicastRemoteObject implements Prog2I
{
    public Prog2S() throws RemoteException{}

    public int getSum(int no1, int no2) throws RemoteException
    {
        System.out.println("Invocation on server successful");
        return no1 + no2;
    }

    public static void main(String args[])
    {
        try
        {
            Prog2S obj = new Prog2S();
            Naming.rebind("refvar1", obj);
            System.out.println("Server object successfully bount to RMI Registry");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}