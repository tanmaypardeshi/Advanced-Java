// Create 3 threads to print the nos. 5,7 and is using Runnable interface. Assign priority to each thread

class Five implements Runnable
{
	// In many examples, we require to use Threads in Java GUI. Im Java GUI, we typically we use a base class like Applet
	// Frame, Canvas, Window and as Java doesn't support multiple inheritance, we need to use an Interface Runnable

	public void run()
	{
		System.out.println("Table of 5");
		for (int i = 1; i <=12; i++)
		{
			System.out.println("5 x " + i + " = " + 5*i);
		}
		System.out.println("End of table no. 5");
	}
}

class Seven implements Runnable
{
	public void run()
	{
		System.out.println("Table of 7");
		for (int i = 1; i <=12; i++)
		{
			System.out.println("7 x " + i + " = " + 7*i);
		}
		System.out.println("End of table no. 7");
	}
}

class Thirteen implements Runnable
{
	public void run()
	{
		System.out.println("Table of 13");
		for (int i = 1; i <=12; i++)
		{
			System.out.println("5 x " + i + " = " + 13*i);
		}
		System.out.println("End of table no. 13");
	}
}

public class Prog2
{
	public static void main(String[] args)
	{
		Five f = new Five();

		// f.start() 	// error, no such method
		/* We cant expect to create a Thread simply by implemeenting the Runnable interface. The Thread is an intelligent
		class which controls the CPU idle time. An interface is nothing but a list of abstract methods and is no comparison
		for Thread. By implementing this interface i.e. the class which implements Runnable interface becomes qualified
		to be used with constructor of Thread class
		 */
		Thread t5 = new Thread(f);
		// short cut
		Thread t7 = new Thread(new Seven());
		Thread t13 = new Thread(new Thirteen());

		// assign priority to each thread - 3 techniques

		// priority levels 1(lesser) - 10(higher)

		t5.setPriority(2);	//absolute priority
		t7.setPriority(t5.getPriority() + 3);	//relative priority
		t13.setPriority(Thread.MAX_PRIORITY);	//MAX_PRIORITY is a constand in Thread class
												//MIN_PRIORITY, NORM_PRIORITY

		t5.start();
		t7.start();
		t13.start();

		System.out.println("End of Thread main()");	//runs on priority level 5 - normal priority
	}
}
