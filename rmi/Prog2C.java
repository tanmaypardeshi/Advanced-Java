
// Client class for GUI

import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Prog2C extends Frame implements ActionListener
{
    String msg = "";
    Label l1,l2;
    TextField textno1,textno2;
    Prog2I obj;

    public static void main(String[] args)
    {
        new Prog2C();
    }
    Prog2C()
    {
        setBounds(400,250,500,500);
        setFont(new Font("Arial", Font.BOLD, 22));
        setLayout(null);

        l1 = new Label("Number 1:- ");
        l2 = new Label("Number 2:- ");

        textno1 = new TextField();
        textno2 = new TextField();

        l1.setBounds(50,50,100,30);
        l2.setBounds(50,120,100,30);

        textno1.setBounds(170,50,100,30);
        textno2.setBounds(170,120,100,30);

        add(l1);
        add(l2);
        add(textno1);
        add(textno2);

        textno1.addActionListener(this);
        textno2.addActionListener(this);
        setVisible(true);   

        try
        {
	        obj  = (Prog2I)Naming.lookup("rmi://localhost:7000/refvar2");
        }
        catch(Exception e)
        {
	        System.out.println(e.getMessage());
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            int no1 = Integer.parseInt(textno1.getText());
            int no2 = Integer.parseInt(textno2.getText());

            msg = "Sum of given numbers is:- " + obj.getSum(no1,no2);
        }
        catch(Exception e)
        {
            msg = e.getMessage();
        }
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawString(msg, 50, 300);
    }
}