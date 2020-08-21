// Design an applet which shows scrolling text (animated text)

import java.applet.*;
import java.awt.*;

/*<applet code = "Prog7.class" width="600" height="600"></applet>*/

public class Prog7 extends Applet implements Runnable {
    String msg;
    Thread t;
    boolean stopFlag;

    // executes only one in lifecycle of applet
    public void init() {
        msg = "Databyte Computers, Pune - 4 ";
        setForeground(Color.RED);
        setBackground(Color.YELLOW);
        setFont(new Font("Arial", Font.BOLD, 23));
    }

    //start() is caled automatically after init() and also again when we switch over to the window/tab containing an
    // applet. As msg is not initialised here, the String will start animation where it was left.

    public void start() {
        stopFlag = false;   //start animation
        t = new Thread(this);
        t.start();
    }

    public void run() {
        // play animation continuosly

        while (true) {
            // generate Strings to display
            char ch = msg.charAt(0);    // get 0th character from String
            msg = msg.substring(1); //get the 1st(actually 2nd). get all chars in msg
            msg += ch;  //append 0th character @ end of msg

            // display newly created String after delay period
            try {
                t.sleep(200);   //1/10th second
            } catch (InterruptedException e) {
            }
            if (stopFlag)
                break;
            repaint();
        }
    }
    // when we minimise the browser window OR move to another tab, the stop() of Applet life cycle is called automatically.
    // Here, if anmation is not required and can be stopped. However if not made part of the program, will affect other processes.

    public void stop() {
        stopFlag = true;
        t = null;   //destroy thread of animation
    }

    public void paint(Graphics g)
    {
        g.drawString(msg, 50, 50);
    }
}