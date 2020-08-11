// an eg. of a vector to store data of an employee

import java.util.*;

public class Prog1
{
	public static void main(String[] args)
	{
		Vector v = new Vector(3);	//vector initialised to a capacity of 3 elements

		System.out.println("Capacity of v:- " + v.capacity());

		v.add(123);	//error in version upto jdk1.4 because collections are designed to work on Object types and
		// and not primitive data types. In jdk1.5 java was included with a feature called as auto-boxing which
		// auto converts/boxes pdt into respective Object type and then adds it to the Vector.
		// int pdt --> Integer obj, char pdt --> Character obj, etc/

		//v.add(new Integer(123));	//int pdt --> Integer obj manually
		//auto unboxing is converting Integer obj --> int pdt

		v.addElement("Joshi");
		v.add("Pune");
		v.insertElementAt("Sunil", 1);
		v.add(1000.34);	//v.add(new Double(1000.34));	//auto boxing

		System.out.println("v contains:- " + v);
		System.out.println("Capacity of v is:- " + v.capacity());

		v.removeElementAt(2);

		//v.removeElement("Joshi");	//will not give error if not found

		System.out.println("v contains:- " + v);
		System.out.println("Capacity of v is:- " + v.capacity());
		System.out.println("Elements of v using for loop is:- ");
		// alternatvie techniques to access elements seperately
		for (int i = 0; i < v.size(); i++)
		{
			System.out.println(v.elementAt(i));
		}
		//Collections.sort(v1);	//error, heterogeneous elements
	}
}