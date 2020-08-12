// An eg. of collection which uses user defined type objects only. Design a LinkedList to hold data of Students

import java.util.LinkedList;

class Student
{
	int rollno;
	String name;
	double per;

	Student(int r, String n, double p)
	{
		rollno = r;
		name = n;
		per = p;
	}

	public String toString()
	{
		return "'" + rollno + ", " + name + ", " + per + "'";
	}
}

class Prog4
{
	public static void main(String[] args)
	{
		LinkedList<Student> l = new LinkedList<Student>();

		l.add(new Student(1,"Tanmay", 91.69));
		l.add(new Student(2,"Atharva", 88.80));
		l.add(new Student(3,"Ankit", 67.59));
		l.add(new Student(4,"Ashay", 71.34));
		l.add(new Student(5,"Rohit", 91.50));

		System.out.println("l contains:- " + l);
		// optional technique use for each loop
		System.out.println("Using for each loop, elements are:- ");
		for (Student el : l) 	//for each element of type Student
		{
			System.out.println(el);
		}

	}
}