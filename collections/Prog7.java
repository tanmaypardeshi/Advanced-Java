// Create a Hashtable to store names and percent of students and later display them along wuth the name and pecent
// if students who secured maximum percent

import java.util.*;

class Prog7
{
    public static void main(String[] args)
    {
        Hashtable <String, Double> ht = new Hashtable<String, Double>();

        // The Hashtavle is created with some default capacity and a default fill ratio. When we add an element in the
        // Hashtable and number of vacant spaces are less than capacity * fillratio, then only the hash table capacity
        // increases. Ideal fill ratio is 0.75

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements:- ");
        int nor = sc.nextInt();

        for (int i = 0; i < nor; i++)
        {
            System.out.print("Enter name:- ");
            String name = sc.next();
            System.out.print("Enter marks in %:- ");
            double per = sc.nextDouble();
            // Hashtable contains method put() and not add() because Hashtable doesnt store data like a sequence

            ht.put(name, new Double(per));
        }

        // The Hashtable uses some internal algorithm(a function) to store and retireve the data and hence it doesnt
        // guarantee the order of elements during its display.
        // Allow the Hashtable doesn't have its own method to iterate between all its elements. It re;ies on another
        // Collection interface called as Enumeration which holds the keys of Hashtable.

        // To disply all records

        Enumeration <String> e = ht.keys();

        // to know student with highest marks

        String name1 = "";
        double per1 = 0;
        System.out.println("Data is:- ");
        while(e.hasMoreElements())
        {
            String name = e.nextElement();  // get the key frame
            double per = ht.get(name);  //auto unboxing i.e. auto convert Double obj to double pdt

            System.out.println(name + "\t" + per);
            if(per1 < per)
            {
                per1 = per;
                name1 = name;
            }
        }
        System.out.println("Topper is:- " + name1 + " with marks:- " + per1);
    }
}