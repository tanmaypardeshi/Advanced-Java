// An example of blocked states of Thread. Examples of yield(), sleep() and join().
// yield() - Asks the thread to surrender its turn to the next thread and again wait for its turn at the end of queue
// sleep(time in ms) - Asks the thread to pause for a given time period and then continue its execution again
// join() - Prevents the other thread from entering the runnable state till its execution is not complete

class A extends Thread
{
	public void run()
	{
		System.out.println("Start of thread A");
		for (int i = 0; i < 15; i++)
		{
			System.out.println("i= " + i);
			if(i == 10)
				Thread.yield();
		}
		System.out.println("End of thread A");
	}
}

class B extends Thread
{
	public void run()
	{
		System.out.println("Start of Thread B");
		for (int j = 0; j < 15; j++)
		{
			System.out.println("j = " + j);
			if(j == 10)
			{
				try
				{
					sleep(1000);
				}
				catch (InterruptedException ignored)
				{}
			}
		}
		System.out.println("End of Thread B");
	}
}

class C extends Thread
{
	public void run()
	{
		System.out.println("Start of Thread C");
		for (int k = 0; k < 15; k++)
		{
			System.out.println("k = " + k);
		}
		System.out.println("End of Thread C");
	}

}

class Prog4
{
	public static void main(String[] args) throws InterruptedException
	{
			A ta = new A();
			B tb = new B();
			C tc = new C();

			ta.start();	//Runnable state
			tb.start();
			ta.join();	//will start Thread C only after Thread A reaches Dead state
			tc.start();
			System.out.println("End of thread main()");
	}
}