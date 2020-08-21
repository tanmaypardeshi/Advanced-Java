// Design a frame which displays a dynamic clock

import java.awt.*;  //Frame class
import java.util.*; //Date class

class Prog6 extends Frame implements Runnable
{
    Thread t;   // Thread object will be shared among all std methods

    public static void main(String args[])
    {
        new Prog6();
    }

    Prog6()
    {
        setBounds(250,125,500,500);
        setFont(new Font("Arial", Font.BOLD, 25));
        // create a new Thread for the Frame
        t = new Thread(this);   // constructor of Thread class accepts the Frame object because it is implementing
                                // Runnable interface
        t.start();
        setVisible(true);
    }

    public void run()
    {
        while (true) {
            // set a delay period of 1 second for the clock because our clock refreshes the time every one second
            try {
                t.sleep(1000);  // 1 second, to refresh every min, give 60,000
            } catch (InterruptedException e) {
            }
            repaint();
        }
    }

    public void paint(Graphics g)
    {
        Date d = new Date();
//        g.drawString(d.toString(), 50,100);    // displays data and time both
        int hrs = d.getHours();
        int mins = d.getMinutes();
        int seconds = d.getSeconds();

//        g.drawString(hrs + ":" + mins + ":" + seconds, 100,100);

        String status = "AM";

        if(hrs > 12)
        {
            hrs -= 12;
            status = "PM";
        }
        if(hrs == 12)
        {
            status = "PM";
        }
        if(hrs == 0)
        {
            hrs = 12;
        }
//        g.drawString(hrs + ":" + mins + ":" + seconds + status, 100,100);

        // show mins and seconds always as 2 digit numbers
        String tmins, tsecs;
        if(mins < 10)
        {
            tmins = "0" + mins;
        }
        else
        {
            tmins = "" + mins;
        }
        if(seconds < 10)
        {
            tsecs = "0" + mins;
        }
        else
        {
            tsecs = "" + seconds;
        }
        g.drawString(hrs + ":" + tmins + ":" + tsecs + status, 160,100);
    }
}