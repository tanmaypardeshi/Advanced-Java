// an example of stack to store names of Students and display them
// also write code to search for one of the names

import java.util.*;

public class Prog13
{
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();

		s.push("Meena");	//bottom
		s.push("Veena");
		s.push("Aditya");
		s.push("Paresh");
		s.push("Amrita");

		System.out.println("Contents of stack are:- ");

		for (int i = s.size() - 1; i >= 0; i--)
		{
			System.out.println(s.get(i));
		}

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter name to search:- ");

		String name = sc.next();

		int pos = s.search(name);

		if(pos == -1)
			System.out.println("Name " + name + " not found in stack");
		else
			System.out.println("Name " + name + " found in Stack @ position " + pos + " from top of stack");

		// empty the entire Stack and while doing so, display name popped

		while(s.isEmpty())
		{
			System.out.println("Elements popped is:- " + s.pop());
		}
	}
}