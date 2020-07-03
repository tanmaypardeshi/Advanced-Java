//accept a record of employee from user and store it int the table "empinfo"

import java.sql.*;
import java.util.Scanner;

public class Prog5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id:- ");
        int id = sc.nextInt();
        System.out.print("Enter name:- ");
        String name = sc.next();
        System.out.print("Enter surname:- ");
        String surname = sc.next();
        System.out.print("Enter city:- ");
        String cname = sc.next();
        System.out.print("Enter salary:- ");
        double sal = sc.nextDouble();

        try
        {
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);
            Statement stmt = conn.createStatement();
            String sql = "insert into empinfo values('" + name + "','" + surname + "','" + cname + "'," + sal + "," + id + ")";

            stmt.executeUpdate(sql);

            System.out.println("Rcecord inserted successfully");

            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
