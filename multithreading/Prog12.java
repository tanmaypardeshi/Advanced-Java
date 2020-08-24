// Write a synchronised method in which 1 thread calculates the sum of numbers from 1-100 while other thread displays
// it.

class Sum
{
	int total;
	String tname;
	boolean display = false;	// instruction of thread not to display

	synchronized void meth()
	{
		tname = Thread.currentThread().getName();
		// now suppose the display thread enters first
		if(!display)
		{
			display = true;
			try
			{
				System.out.println(tname + " is waiting till total is not calculated");		//how long the other needs
				// to calculate is not known
				wait();	//like sleep() and join9) it throws checked exception
			}
			catch (InterruptedException e){}
			System.out.println("Total is = " + total);
		}
		else
		{
			// thread supposed to carry caluclation
			total = 0;
			for (int i = 0; i < 100; i++)
			{
				total += i;

			}
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException e)
			{

			}
			System.out.println(tname + " has calculated total");
			notify();	//wake up the other thread
		}
	}
}

class ThreadDemo extends Thread
{
	Sum s;
	ThreadDemo(Sum s)
	{
		this.s = s;
		start();
	}
	public void run()
	{
		s.meth();
	}
}

class Prog12
{
	public static void main(String[] args)
	{
		Sum objs = new Sum();
		new ThreadDemo(objs);
		new ThreadDemo(objs);
	}
}