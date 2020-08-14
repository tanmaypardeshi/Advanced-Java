// Example of HashSet

import java.util.*;

class Prog9
{
    public static void main(String[] args)
    {
        HashSet<Character> hs = new HashSet<Character>();
        hs.add('C');    // add() and not put() because it is also implementing set interface which is a sub interface of
                        // Collection
        hs.add('O');
        hs.add('N');
        hs.add('T');
        hs.add('E');
        hs.add('N');
        hs.add('T');
        hs.add('S');

        System.out.println("hs contains:- " + hs);

        // in case we need to access each element of "hs", then obtain an Iterator

        Iterator i = hs.iterator();

        System.out.println("Each value in hs is:- ");
        while(i.hasNext())  //boolean
        {
            System.out.println(i.next());
        }
    }
}