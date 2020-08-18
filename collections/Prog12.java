// Design a TreeMap to accept the names and balance in their account in a banking application. Alter the balance
// of one of the account holders

import java.util.*;

public class Prog12
{
	public static void main(String[] args)
	{
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();

		// the TreeMap also uses put() and get() like Hashtable to store and retrieve data

		tm.put("Paresh", 1000);
		tm.put("Pratik", 1500);
		tm.put("Sunil", 1600);
		tm.put("Mahesh", 1200);
		tm.put("Paresh", 1200); 	//previous name will get overwritten

		System.out.println("Records from tm are:- " + tm);

		// to modify balance of Sunil and add rupees 2500

		int bal = tm.get("Sunil");	//auto unboxing i.e. Integer --> int

		bal += 2500;

		tm.put("Sunil", bal);	// auto boxing

		System.out.println("Records from tm are:- " + tm);

		// to access each record independently in case of mass changes 1st obtain the keys of collection in Set

		Set<String> s = tm.keySet();

		// obtain an iterator for Set

		Iterator<String> i = s.iterator();

		while(i.hasNext())
		{
			String key = i.next();
			System.out.println(key + " -- " + tm.get(key));
		}
	}
}