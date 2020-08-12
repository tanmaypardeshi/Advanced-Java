// An eg. of collection which uses user defined type objects only. Design a LinkedList to hold data of Students
// Sort data by percent("primary key") in DESCENDING ORDER and sort data by name("secondary key") in ASCENDING ORDER
// if percent is same

import java.util.Collections;
import java.util.Comparator;
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

class MyComparator implements Comparator 	//interface
{
	// override the method compare()

	public int compare(Object o1, Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;

		// compare the percent

		if(s1.per < s2.per)
		{
			return  1;	//swap
		}
		else if(s1.per > s2.per)
		{
			return -1;	//dont swap
		}
		else
		{
			//if percentages are equal
			if(s1.name.compareTo(s2.name) > 0)
			{
				return 1;	//swap
			}
			else
			{
				return -1;	//dont swap
			}
		}
	}
}

class Prog5
{
	public static void main(String[] args)
	{
		LinkedList<Student> l = new LinkedList<Student>();

		l.add(new Student(1,"Tanmay", 91.69));
		l.add(new Student(2,"Atharva", 88.80));
		l.add(new Student(3,"Ankit", 67.59));
		l.add(new Student(4,"Ashay", 71.34));
		l.add(new Student(5,"Rohit", 88.80));

		//Collections.sort(l); //error, no such method sort(Student)
		// So here, natural ordering is not possible for 2 reasons
		// 1. Student is not a built in datatype
		// 2. Contains multiple values

		// The solution to this problem is to pass another parameter to sort() which will serve as a guideline for sort()

		Collections.sort(l, new MyComparator());	// 2nd argument is created on thr fly using user defined class


		System.out.println("l contains:- " + l);
		// optional technique use for each loop
		System.out.println("Using for each loop, elements are:- ");
		for (Student el : l) 	//for each element of type Student
		{
			System.out.println(el);
		}
	}
}

