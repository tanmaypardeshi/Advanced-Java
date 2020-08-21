// WAP to demonstrate life cycle of thread. Make every thread sleep for 0 -5 seconds. Make 3 threads

class ThreadCycle extends Thread
{
    String name;

    ThreadCycle(String name)
    {
        this.name = name;
        System.out.println("Thread " + name + " in Newborn state");
        System.out.println("Thread " + name + " in Runnable state");
        start();
    }

    public void run()
    {
        System.out.println("Thread " + name + " in running state");
        int  i = (int)(Math.random() * 5000);
        System.out.println("Thread " + name + " is sleeping for " + i + "ms");
        try
        {
            sleep(i);
        }
        catch(InterruptedException e)
        {

        }
        System.out.println("Thread " + name + " reached dead state");
    }
}

class Prog5
{
    public static void main(String[] args)
    {
        ThreadCycle ta = new ThreadCycle("ta");
        ThreadCycle tb = new ThreadCycle("tb");
        ThreadCycle tc = new ThreadCycle("tc");
    }
}