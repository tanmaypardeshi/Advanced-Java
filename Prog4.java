// accept the city name from user and delete all records for that city. At the end, display no, of records deleted

import java.sql.*;
import java.util.Scanner;

public class Prog4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name:- ");
        String cname = sc.nextLine();

        try
        {
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);

            Statement stmt = conn.createStatement();

            String sql = "delete from empinfo where city = '"+ cname +"'";


            /* To execute select query, we call executeQuery of Statement object. However, to execute insert, update
            and delete we call executeUpdate() of the Statement object/
            The return type of executeQuery() was an object of type ResultSet.
            The return type of executeUpdate() is always an int value i.e. this method returns no. of records
            affected by the query
             */
            int count = stmt.executeUpdate(sql);

            if(count == 0)
            {
                System.out.println("Records with city nane " + cname + " not found");
            }
            else
            {
                System.out.println("No. of records deleted are " + count);
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
