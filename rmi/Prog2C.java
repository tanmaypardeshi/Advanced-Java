// Client class for GUI

import java.rmi.*;
import java.util.*;

public class Prog2C
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            Prog2I obj = (Prog2I)Naming.lookup("rmi://localhost/refvar1");
            System.out.println("Enter number 1:- ");
            int no1 = sc.nextInt();
            System.out.println("Enter number 2:- ");
            int no2 = sc.nextInt();

            System.out.println("Sum of " + no1 + " and " + no2 + " is " + obj.getSum(no1,no2));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}