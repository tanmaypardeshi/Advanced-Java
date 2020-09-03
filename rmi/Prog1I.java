// an interface

import java.rmi.*;  // Remote interface, RemoteException class

public interface Prog1I extends Remote
{
    // declare a method for Server to be invoked by Client
    public String getMsg() throws RemoteException;
}

