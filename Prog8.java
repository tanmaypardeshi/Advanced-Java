// Accept a record from user and store it in "empinfo" using PreparedStatement Object

import java.sql.*;
import java.util.Scanner;

public class Prog8 {
    public static void main(String[] args) {
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

        try {
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);
            String sql = "insert into empinfo values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(5, id);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, cname);
            ps.setDouble(4, sal);

            ps.executeUpdate();
            System.out.println("Inserted Successfully");

            ps.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}