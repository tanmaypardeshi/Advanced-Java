// Display bouncing ball in APplet window

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/* <applet code="Prog9.class" width="500" height="500"></applet> */

public class Prog9 extends Applet implements ActionListener
{
    // Here Applet is not kept in Thread, the but Ball is
    Button btnstart;
    Ball b1,b2;
    int cntr = 0;   //to determine no. of clicks

    public void init()
    {
        btnstart = new Button("Start");
        add(btnstart);
        btnstart.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        // 1st click, red ball originates

        if(cntr == 0)
        {
            b1 = new Ball(0,0,50,50);   // balls drawn in a box
            cntr++;
        }
        else    //next click
        {
            b2 = new Ball(75,0,50,50);
            btnstart.setEnabled(false);
        }
    }

    // iner class
    class Ball implements Runnable
    {
        int x,y,w,ht,incry,incrx;
        Thread t;

        Ball(int x,int y,int w,int ht)
        {
            this.x = x;
            this.y = y;
            this.w = w;
            this.ht = ht;
            // positive because ball descends
            incrx = 1;
            incry = 1;
            //create a new thread for each ball
            t = new Thread(this);   //new born state
            t.start();  //runnable state
        }

        public void run()
        {
            // the animation should run continuosly
            while(true)
            {
                y += incry;
                x += incrx;
                //if ball reaches either end of the applet window, we bounce it
                if(y == getSize().height - ht || y == 0)
                {
                    incry = -incry; //change sign
                }
                if(x == getSize().width - w || y == 0)
                {
                    incrx = -incrx;
                }
                // now display the new position of the ball but after a delay
                try
                {
                    t.sleep(40);
                }
                catch (InterruptedException e){}

                repaint();  //outer class method
            }
        }
    }
    public void paint(Graphics g)
    {
        try
        {
            g.setColor(Color.RED);
            g.fillOval(b1.x,b1.y,b1.w,b1.ht);
            g.setColor(Color.GREEN);
            g.fillOval(b2.x,b2.y,b2.w,b2.ht);
        }
        catch(NullPointerException e){}
    }
}