// create an ArrayList to store the data of a Stuent and display it in either direction

import java.util.*;

class Prog6
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();

        al.add(123);
        al.add("Manish");
        al.add(878.56);
        al.add("A");    //grade

        System.out.println("Elements from left to right are:- ");
        for (int i = 0; i < al.size(); i++)
        {
            System.out.println(al.get(i));  //behaviour like queue
        }
        for (int i = al.size()-1; i>=0 ;i--)
        {
            System.out.println(al.get(i));  //behavious like stack
        }

        // to get the data of ArrayList Collection into Array

        Object arr[] = al.toArray();

        // Principle is dynamic method dispatch where a super class reference can refer to sub class objects

        System.out.println("Contents of array are:- ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i] + "\t" + arr[i].getClass().getName());
        }
    }
}