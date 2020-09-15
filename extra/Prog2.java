// an eg. of Comparable interface. Design a class Student with fields rollno, name and per. Add the data of Students in
// a Lined List and display them in descending order by percent and if same percent in ascending order by name using
// Comparable interface

import java.util.*;

class Student implements Comparable<Student>
// so here we will not override compareTo() with object parameter but Student parameter
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
		return rollno + ", " + name  + ", " + per;
	}

	public int compareTo(Student s)
	{
		if(this.per < s.per) // the object passed is compared compared with itself
		{
			return 1;
		}
		else if(this.per > s.per)
		{
			return -1;
		}
		else	//if percent is same
		{
			// compare the names
			if(this.name.compareTo(s.name) > 0)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
	}
}

public class Prog2
{
	public static void main(String[] args)
	{
		LinkedList<Student> l = new LinkedList<Student>();

		l.add(new Student(1,"Tanmay", 91.69));
		l.add(new Student(2,"Atharva", 88.80));
		l.add(new Student(3,"Rachit", 71.34));
		l.add(new Student(4,"Ashay", 71.34));
		l.add(new Student(5,"Rohit", 91.50));

		Collections.sort(l);	// OK, becuase the LinkedList contains objects of Student class which defines its natural
								// ordering
		System.out.println("l contains:- ");
		for(Student s:l)
		{
			System.out.println(s);
		}
	}
}
