// Design an applet which shows scrolling text in the opposite direction of Prog7

import java.applet.*;
import java.awt.*;
import java.awt.*;
/*<applet code="Prog8.class" width="600" height="600"></applet>*/

public class Prog8 extends Applet implements Runnable
{
    String msg, msg2;
    Thread t;
    boolean stopFlag;

    public void init()
    {
        msg = "Databyte Computers, Pune - 4 ";
        setForeground(Color.RED);
        setBackground(Color.YELLOW);
        setFont(new Font("Arial", Font.BOLD, 23));
    }

    public void start()
    {
        stopFlag = false;
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        while (true) {
            char ch = msg.charAt(msg.length()-1);
            msg = msg.substring(0, msg.length() - 1);
            msg = ch + msg;

            try
            {
                t.sleep(200);
            } catch (InterruptedException e) {}
            if (stopFlag)
                break;
            repaint();
        }
    }
    
    public void stop()
    {
        stopFlag = true;
        t = null;   //destroy thread of animation
    }

    public void paint(Graphics g)
    {
        g.drawString(msg, 50, 50);
    }
}
