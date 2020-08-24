// an eg. of synchronised method

class Call
{
	synchronized void callMe()
	{
		System.out.print("[" + Thread.currentThread().getName() + " is inside");
		// set a delay period just to indicate that some process is being done by this method
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {}
		System.out.println("]");
	}
}

class ThreadDemo extends Thread {
	Call c;

	ThreadDemo(Call c) {
		this.c = c;
		start();    //Runnable state
	}

	// Running state
	public void run()
	{
		c.callMe();
	}
}

class Prog10
{
	public static void main(String[] args)
	{
		Call objc = new Call();
		// share this object using 2 threads
		new ThreadDemo(objc);
		new ThreadDemo(objc);
	}
}
