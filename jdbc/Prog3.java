// Accept a city name from user as cmd args and display records of that city

import java.sql.*;


public class Prog3
{
    public static void main(String[] args)
    {
        try
        {
            String cname = args[0];

            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);

            Statement stmt = conn.createStatement();

            String sql = "select * from empinfo where city = '"+ cname +"'";

            //Alternate way of designing query
            // String sql = "select * from empinfo where city = \""+ cname +"\"";
            ResultSet rs =stmt.executeQuery(sql);

            /* instead of using if, use "while" loop because "city" is not a primary key and we can have multiple records
            for a particular city.*/

            boolean flag = false;   //rs is empty
            int count = 0;
            while(rs.next())
            {
                //to display column heading only
                if(!flag)
                {
                    System.out.println("Empid\tName\tSurname\tCity\tSalary");
                    flag = true;
                }
                System.out.println(rs.getInt("empid") + "\t" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
                count++;
            }
            if(!flag)
            {
                System.out.println("Record with city name " + cname + " not found");
            }
            else
            {
                System.out.println("No. of records are " + count);
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Enter a city name");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
