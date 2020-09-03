// Interface for GUI application

import java.rmi.*;

public interface Prog2I extends Remote
{
    public int getSum(int no1, int no2) throws RemoteException;
}