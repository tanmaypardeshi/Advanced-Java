// Create 3 threads to print numbers from 1- 15

class A extends Thread
{
	// compulsory to override because run() of 2 or more threads concurrently

	// Thread is not an abstract class and run() is not an abstract method. But we would like to use idle time of
	// CPU when multiple processes are being carried out simultaneously and all processes are independent of each other

	public void run()
	{
		System.out.println("Start of thread A");
		for (int i = 1; i <= 15 ; i++)
		{
			System.out.println("i = " + i);
		}
		System.out.println("End of thread A");
	}

}

class B extends Thread
{

	public void run()
	{
		System.out.println("Start of thread B");
		for (int j = 1; j <= 15 ; j++)
		{
			System.out.println("j = " + j);
		}
		System.out.println("End of thread B");
	}
}

class C extends Thread
{

	public void run()
	{
		System.out.println("Start of thread C");
		for (int k = 1; k <= 15 ; k++)
		{
			System.out.println("k = " + k);
		}
		System.out.println("End of thread C");
	}
}

class Prog1
{
	public static void main(String[] args) {
		// Newborn state

		A ta = new A();
		B tb = new B();
		C tc = new C();

		// Runnable state, threads are arranged in a queue, the JRE will allocate a slice of time for each thread for
		// which it will execute. The run() is called internally

		ta.start();
		tb.start();
		tc.start();

		System.out.println("End of thread main()");	// main() also requires CPU time and hence is on a Thread
	}
}