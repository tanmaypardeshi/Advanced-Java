import java.io.*;

class Fib extends Thread
{
    public void run()
    {
        System.out.println("Start of thread Fib: ");
        int a = 0, b = 1, c = 0;
        System.out.println("Term 1: " + a);
        System.out.println("Term 2: " + b);
        for (int i = 3; i <= 20; i++)
        {
            c = a+b;
            System.out.println("Term " + i + ": " + c);
            a=b;
            b=c;
        }
        System.out.println("End of thread Fib ");
    }
}

class Rev extends Thread
{
    public void run()
    {
        System.out.println("Start of thread Rev: ");

        for (int i = 1000; i >= 1; i--)
        {
            String s = String.valueOf(i);
            StringBuilder input = new StringBuilder();
            input.append(s);
            input = input.reverse();
            System.out.println(input);

        }

        System.out.println("End of thread Rev ");
    }
}

public class Prog3
{
    public static void main(String args[])
    {
        Fib f = new Fib();
        Rev r = new Rev();

        f.start();
        r.start();
        System.out.println("End of thread Main ");
    }
}
