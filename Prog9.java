// To design a GUI using AWT for a login screen

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Prog9 extends Frame
{
    //declare controls globally so that hey are accessbile to all standard java methods

    Label l1,l2,lblinfo;
    TextField txtun,txtpwd;
    Button btnlogin,btncancel;

    public static void main(String[] args)
    {
        new Prog9();    //create a nameless frame object
    }
    //constructor
    Prog9()
    {
        //set the properties of the frame
        setTitle("Login Screen");
        setBounds(250,125,500,500);
        setFont(new Font("Arial", Font.BOLD, 20));
        setLayout(null);    //Manual Layout

        //create the components
        l1 = new Label("Username");
        l2 = new Label("Password");
        txtun = new TextField();
        txtpwd = new TextField();
        txtpwd.setEchoChar('*');    //Password is masked

        btnlogin = new Button("Login");
        btncancel = new Button("Cancel");

        lblinfo = new Label("Welcome to Databyte");

        //decide the margins and size of each component

        l1.setBounds(50,50,100,30);
        l2.setBounds(50,105,100,30);
        txtun.setBounds(170,50,200,30);
        txtpwd.setBounds(170,105,200,30);
        btnlogin.setBounds(50,175,80,30);
        btncancel.setBounds(150,175,80,30);
        lblinfo.setBounds(50,250,300,30);

        //add each component to frame
        add(l1);
        add(l2);
        add(txtun);
        add(txtpwd);
        add(btnlogin);
        add(btncancel);
        add(lblinfo);

        //register the buttons for eventhandling

        btnlogin.addActionListener(new MyLogin());
        btncancel.addActionListener(new MyCancel());

        //object of class MyLogin will handle the login event and similary MyCancel will handle exit event

        setVisible(true);
    }
    //user defined inner/nested class for handling the events because the inner class has complete access to all
    //members of enclosing class

    class MyLogin implements ActionListener
    {
        //override the method ActionListener interface

        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
                Connection conn = DriverManager.getConnection(databaseURL);
                String sql = "select * from users where username = ? and password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, txtun.getText());
                ps.setString(2, txtpwd.getText());

                ResultSet rs = ps.executeQuery();


                if(rs.next())
                {
                    lblinfo.setText("Login Successful");
                }
                else
                {
                    lblinfo.setText("Login Unsuccessful");
                }
                rs.close();
                ps.close();
                conn.close();

            }
            catch (Exception e)
            {
                lblinfo.setText(e.getMessage());

                //This program can be executed from a shortcut provided on desktop by our client.
                //So SOP and command prompt are nowhere to be seen by user.
            }
        }
    }
    class MyCancel implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            System.exit(0);
        }
    }
}
