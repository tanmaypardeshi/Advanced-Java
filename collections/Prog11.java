// Example of TreeSet

import java.util.*;

class Prog11
{
    public static void main(String[] args)
    {
        TreeSet<Character> ts = new TreeSet<Character>();
        ts.add('C');    // add() and not put() because it is also implementing set interface which is a sub interface of
        // Collection
        ts.add('O');
        ts.add('N');
        ts.add('T');
        ts.add('E');
        ts.add('N');
        ts.add('T');
        ts.add('S');

        System.out.println("ts contains:- " + ts);

        // in case we need to access each element of "hs", then obtain an Iterator

        Iterator i = ts.iterator();

        System.out.println("Each value in ts is:- ");
        while(i.hasNext())  //boolean
        {
            System.out.println(i.next());
        }
    }
}