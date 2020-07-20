// An eg. of update query - This query is used to modify the contents of 1 or more records
// WAP which modifies the name of a city for eg. by mistake city name is typed as "Pune" instead of "Poona"

import javax.swing.tree.ExpandVetoException;
import java.sql.*;
import java.util.Scanner;

public class Prog6
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name:- ");
        String old_city = sc.next();
        System.out.print("Enter new name:- ");
        String new_city = sc.next();

        try
        {
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);
            Statement stmt = conn.createStatement();
            /* syntax of update query:
            update tablename set field1=value1, field2=value2 where fieldn=valuen
             */
            String sql = "update empinfo set city = '" + new_city + "' where city = '" + old_city + "'";

            int count = stmt.executeUpdate(sql);

            if(count == 0)
            {
                System.out.println("Record with city " + old_city + " not found");
            }
            else
            {
                System.out.println(count + " no. of records modified successfully");
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
