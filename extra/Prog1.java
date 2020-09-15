// an eg. of Comparator interface to compare and sort 2 objects of different types say Manager and Salesman

import java.util.*;

class Employee
{
	int salary;	// common field
}

class Manager extends Employee
{
	String name;
	// can add any other fields which may differ with Salesman

	Manager(String n, int s)
	{
		// no constructor in super class
		// super();	 // called by default and compiler creates one
		name = n;
		salary = s;
	}

	public String toString()
	{
		return name + " Manager, " + salary;
	}
}

class Salesman extends Employee
{
	String name;
	// can add any other fields which may differ with Salesman

	Salesman(String n, int s)
	{
		// no constructor in super class
		// super();	 // called by default and compiler creates one
		name = n;
		salary = s;
	}

	public String toString()
	{
		return name + " Salesman, " + salary;
	}
}
public class Prog1
{
	public static void main(String[] args)
	{
		LinkedList<Employee> l = new LinkedList<Employee>();
		l.add(new Manager("Sameer", 25000));
		l.add(new Salesman("Mahesh", 15000));
		l.add(new Manager("Ranjit", 25400));
		l.add(new Salesman("Rahul", 5000));
		l.add(new Salesman("Aditya", 10000));
		l.add(new Manager("Kedar", 250000));
		l.add(new Manager("Sandesh", 50000));
		l.add(new Salesman("Rajesh", 5000));

		// Collections.sort(l);	// error, no such method sort(l<Employee>)

		Collections.sort(l, new MyComparator());	// MyComparator() object will consist the sort() on what is the basis
													// of sorting

		System.out.println("Sorted list l is:- ");
		for(Employee e: l)
		{
			System.out.println(e);
		}
	}
}

class MyComparator implements Comparator<Employee>
{
	// now override the compare() using Employee object - safe

	public int compare(Employee e1, Employee e2)
	{
		if(e1.salary < e2.salary)
			return 1;
		return -1;
	}
}
