// Design a Hashtable to store empid, name, age and salary of employee

import java.util.*;

class Emp
{
    private int age;
    private String name;
    private double salary;

    Emp(int a, String n, double s)
    {
        age = a;
        name = n;
        salary = s;
    }

    public String toString()
    {
        return "Name:- " + name + ", Age:- " + age + ", Salary:- " + salary + "\n";
    }
}

public class Prog8
{
    public static void main(String[] args)
    {
        Hashtable<Integer, Emp> ht = new Hashtable<Integer, Emp>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of records:- ");

        int nor = sc.nextInt();

        for (int i = 0; i < nor; i++)
        {
            System.out.print("Enter empid:- ");
            int empid = sc.nextInt();
            System.out.print("Enter name:- ");
            String name = sc.next();
            System.out.print("Enter age:- ");
            int age = sc.nextInt();
            System.out.print("Enter salary:- ");
            double salary = sc.nextDouble();
            ht.put(new Integer(empid), new Emp(age,name, salary));
        }

        Enumeration <Integer> e = ht.keys();

        while(e.hasMoreElements())
        {
            Integer empid = e.nextElement();

            Emp object = ht.get(empid);


            System.out.println("Emp ID:- " + empid + "\t");
            System.out.println(object);
        }
    }
}