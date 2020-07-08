// GUI in swing to manage customer records

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Prog10 extends JFrame implements ActionListener
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

        btnnext.addActionListener(this);
        btnprev.addActionListener(this);
        btnfirst.addActionListener(this);
        btnlast.addActionListener(this);
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
        try {
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            conn = DriverManager.getConnection(databaseURL);
            //dont declare objects again, otherwise local DB objects will get created and will lead to null pointer
            //exception
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "select * from customer";

            //to display the first record on screen
            rs = stmt.executeQuery(sql);
            rs.next();  //DB cursor moves from BOF to 1st record in RAM but we want the current record i.e. first record
            //to be displayed on screen.

            showRec();  // user defined method
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    void showRec()
    {
        try
        {
            txtid.setText(Integer.toString(rs.getInt("custid")));
            txtfn.setText(rs.getString("fname"));
            //txtid.setText(rs.getInt("custid"));
            //The return type of getInt is int and setText(String) so it will give an error.
            //We can also use txtid.setText(""+rs.getInt("custid"); //OK
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
            //first we would like to know which button is clicked
            if(ae.getSource() == btnnext)
            {
                //1st check the last record is on screen or not
                if(rs.isLast()) //boolean method
                {
                    JOptionPane.showMessageDialog(this,"Already at last record!", "Navigation Error", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    //in general, we will invoke this method only if DB cursor is not at last record. otherwise we get excption
                    //"Invalid cursor state"
                    rs.next();
                    //to display record on screen
                    showRec();
                }
            }
            else if(ae.getSource() == btnprev)
            {
                //1st check the first record is on screen or mot
                if(rs.isFirst())
                {
                    JOptionPane.showMessageDialog(this,"Already at first record!", "Navigation Error", JOptionPane.INFORMATION_MESSAGE);
                    //this means center of frame but if we use null it means the message dialog will pop up on center of screen
                }
                else
                {
                    rs.previous();
                    showRec();
                }
            }
            else if(ae.getSource() == btnlast)
            {
                rs.last();
                showRec();
            }
            else if(ae.getSource() == btnfirst)
            {
                rs.first();
                showRec();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

/* When we create a ResultSet object, by default it contains a DB cursor which is of type TYPE_FORWARD_ONLY which can
move from first to last record only once. This cursor is light weight and hence very efficient.

-> BOF (Invalid cursor state) - if request is to display records
    1
    2
    3
    4
    EOF (Invalid cursor state) - if request is to display records

    If you want the cursor to move in either direction, we have to set a property of ResultSet object before it gets
    created. So set this property before it is created.

    Opposite of forward cursor is a scrollable cursor. Also as Java is programming language used for networking
    application, INSENSITIVE cursor means it provides a static view of data. It means if some other user makes a change
    in data, you may not notice it. However, SENSITIVE cursor provides you with dynamic view of data.

    The second property makes the ResultSet updatable programmatically other it is type READ_ONLY.

    JOptionPane is a swing class containing a static method showMessgeDisplay(). This method has 4 parameters.
    1. Position(null or this) 2. Mesage to display 3. Title for message. 4. Icon

 */