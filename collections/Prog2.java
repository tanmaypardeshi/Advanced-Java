// An eg. of a vector with generics implemented to operate on a specific data type only. Generics allow us to write
// a single definition for a class to operate on many different data types. The main advantage is that it offers type
// safety

import java.lang.invoke.VolatileCallSite;
import java.util.*;

public class Prog2
{
	public static void main(String[] args)
	{
		Vector<String> v1 = new Vector<String>();

		v1.add("Umesh");
		v1.add("Suresh");
		v1.add("Mangesh");
		v1.add("Beena");
		v1.add("Gauri");
		v1.add("Lata");

		//v1.add(123);	//error, v1 is designed to operate on String type only


		v1.add(Integer.toString(123));	// OK
		// v1.add("123");	//OK
		v1.add("Ramaa");
		System.out.println("v1 contains:- " + v1);

		Collections.sort(v1);

		System.out.println("v1 contains:- " + v1);

		Collections.reverse(v1);

		System.out.println("v1 contains:- " + v1);

		//Vector<int> v1 = new Vector<int>();	//error, pdt not allowed

		Vector<Integer> v2 = new Vector<Integer>();	//OK

		v2.add(100);
		v2.add(120);
		v2.add(-143);
		v2.add(0);
		v2.add(123);
		v2.add(-156);

		System.out.println("v2 contains:- " + v2);
		System.out.println("Maximum element is:- " + Collections.max(v2));
		System.out.println("Minimum element is:- " + Collections.min(v2));


	}
}