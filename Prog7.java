// display the record of an employee whose empid is accepted from user as cmd args. Use PreparedStatement object

import java.sql.*;

public class Prog7
{
    public static void main(String[] args)
    {
        try
        {
            int id = Integer.parseInt(args[0]);
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);

            // IMPORTANT ->design query first for creating PreparedStatement object

            String sql = "select * from empinfo where empid = ?";
            //unknown parameters in query replaced by ?

            PreparedStatement ps = conn.prepareStatement(sql);

            //set the paramter value for query
            ps.setInt(1,id);    //first parameter in query is an integer whose value is obtained from
            //variable "id"

            ResultSet rs = ps.executeQuery();
            // IMPORTANT -> no parameters because ps already contains query

            if(rs.next())
            {
                System.out.println("Record found");
                System.out.println("EmpID\tName\tSurname\tCity\tSalary");
                System.out.println(rs.getInt("empid") + "\t" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));
            }
            else {
                System.out.println("Record with empid " + id + " not found");
            }
            rs.close();
            ps.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
