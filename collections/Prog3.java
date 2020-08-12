// an example of LinkedLIst collection. This collection can also store heterogenuous elements.


import java.util.LinkedList;

public class Prog3
{
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		l.add("Tanmay");
		l.add(123);

		// here, elements do not move like a Vector or an ArrayList which takes a lot of processing time. Instead
		// only links get adjusted

		l.addLast("Pune");	//add() and addList() are same
		//however, add() is overloaded

		l.add(2, "Joshi");	//In LL, there are no inherent positions and every operation is managed using
		// links to individual nodes

		System.out.println("l contains:- " + l);

		l.removeLast();

		//to print individual elements

		System.out.println("Elements of l are:- ");
		for (int i = 0; i < l.size(); i++)
		{
			System.out.println(l.get(i));
		}
	}
}
