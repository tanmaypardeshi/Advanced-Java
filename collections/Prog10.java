// Example of LinkedHashSet

import java.util.*;

class Prog10
{
    public static void main(String[] args)
    {
        LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
        lhs.add('C');    // add() and not put() because it is also implementing set interface which is a sub interface of
        // Collection
        lhs.add('O');
        lhs.add('N');
        lhs.add('T');
        lhs.add('E');
        lhs.add('N');
        lhs.add('T');
        lhs.add('S');

        System.out.println("lhs contains:- " + lhs);

        // in case we need to access each element of "hs", then obtain an Iterator

        Iterator i = lhs.iterator();

        System.out.println("Each value in lhs is:- ");
        while(i.hasNext())  //boolean
        {
            System.out.println(i.next());
        }
    }
}