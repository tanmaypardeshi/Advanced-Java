// an example of synchronised object - In the previous example, the source code of class Call and that of Prog10 was a
// single person. However in many situations, we do not have access to the source code of a class whose method need to be
// called from a synchronised context. In such cases, we need to call the method of that object by calling required method.


class Call
{
	void callMe()
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
		synchronized (c)
		{
			c.callMe();
		}
	}
}

class Prog11
{
	public static void main(String[] args)
	{
		Call objc = new Call();
		// share this object using 2 threads
		new ThreadDemo(objc);
		new ThreadDemo(objc);
	}
}


