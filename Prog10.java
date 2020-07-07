// GUI in swing to manage customer records

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prog10 extends JFrame //implements ActionListener
//to distinguish between awt and swing, swing components start with J
{
    JLabel l1,l2;
    JTextField txtid,txtfn;
    JButton btnnext,btnprev,btnfirst,btnlast,btnnew,btnsave,btnupdate,btndelete;
    
    //IMPORTANT -> declare the SQL components here only so that they can be shared in all methods
    
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public static void main(String[] args) 
    {
        new Prog10();    
    }
    Prog10()
    {
        setTitle("Managing Customer Information");
        setBounds(250,150,500,500);
        setLayout(null);
        //applicable only for frames from swing
        setDefaultCloseOperation(EXIT_ON_CLOSE);      //terminate the application when cross button is pressed
        // However, to close only the current frame and continue the application use
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);   //this is used to close frame but not the entire application
        
        l1 = new JLabel("Customer ID:- ");
        l2 = new JLabel("Full Name:- ");
        txtid = new JTextField();
        txtfn = new JTextField();
        btnnext = new JButton("Next");       
        btnprev = new JButton("Previous");
        btnfirst = new JButton("First");
        btnlast = new JButton("Last");
        btnnew = new JButton("New");
        btnsave = new JButton("Save");
        btnupdate = new JButton("Update");
        btndelete = new JButton("Delete");
        
        
        l1.setBounds(50,50,120,30);
        l2.setBounds(50,130,120,30);
        txtid.setBounds(190,50,60,30);
        txtfn.setBounds(190,130,120,30);
        btnnext.setBounds(50,210,90,30);
        btnprev.setBounds(150,210,90,30);
        btnfirst.setBounds(250,210,90,30);
        btnlast.setBounds(350,210,90,30);
        btnnew.setBounds(50,280,90,30);
        btnsave.setBounds(150,280,90,30);
        btnupdate.setBounds(250,280,90,30);
        btndelete.setBounds(350,280,90,30);

        add(l1);
        add(l2);
        add(txtfn);
        add(txtid);
        add(btnnext);
        add(btnprev);
        add(btnfirst);
        add(btnlast);
        add(btnnew);
        add(btnsave);
        add(btnupdate);
        add(btndelete);

        //btnnext.addActionListener(this);
        //btnprev.addActionListener(this);
        //btnfirst.addActionListener(this);
        //btnlast.addActionListener(this);
        //btnnew.addActionListener(this);
        //btnsave.addActionListener(this);
        //btnupdate.addActionListener(this);
        //btndelete.addActionListener(this);

        setVisible(true);

        // Obtain a connection to backend database. It is better to seperate presentation logic and
        // business/processing logic.

        getConn();  //user defined method
        
    }
    void getConn()
    {
        try
        {
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            conn = DriverManager.getConnection(databaseURL);
            //dont declare objects again, otherwise local DB objects will get created and will lead to null pointer
            //exception
            String sql = "select * from customer";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();
            txtid.setText(Integer.toString(rs.getInt("custid")));
            txtfn.setText(rs.getString("fname"));

        }
        catch (Exception e)
        {}
    }
    
}
