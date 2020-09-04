// Server program for GUI application

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

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
            Registry reg = LocateRegistry.createRegistry(7000);
            Prog2S obj = new Prog2S();
            reg.rebind("refvar2", obj);
            System.out.println("Server object successfully bound to RMI Registry");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}