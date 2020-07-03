/* Accept empid from user as cmd args and display his/her records */
import  java.sql.*;

public class Prog2
{
    public static void main(String[] args)
    {
        try
        {
            // important -> dont open connection with database w/o confirming whether user has specified empid or not

             int id = Integer.parseInt(args[0]);

             String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";

             Connection conn = DriverManager.getConnection(databaseURL);

             Statement stmt = conn.createStatement();

             String sql = "select * from empinfo where empid = " + id;

             ResultSet rs = stmt.executeQuery(sql);

             if(rs.next())
             {
                 System.out.println("Record Found!");
                 System.out.println("Empid\tName\tSurname\tCity\tSalary");
                 System.out.println(rs.getInt("empid") + "\t" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
             }
             else
                 System.out.println("Record with id:- " + id + " not found");

             rs.close();
             stmt.close();
             conn.close();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Please specify empid");
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter figures");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
