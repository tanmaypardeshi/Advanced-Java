// A jva program to execute a procedure from mysql for updating record.

import java.sql.*;

class Prog14
{
    public static void main(String[] args)
    {
        try
        {
            int cid = Integer.parseInt(args[0]);
            String cname = args[1];

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "your_password");
            CallableStatement cstmt = conn.prepareCall("{ call chgdata(?,?)}");

            //set values for IN parameters
            cstmt.setInt(1,cid);
            cstmt.setString(2,cname);

            int count = cstmt.executeUpdate();


            //count will contain number of records affected by the query

            if(count == 0)
            {
                System.out.println("Record not updated because custid not found");
            }
            else
            {             
                System.out.println("Record updated successfully");
            }
            cstmt.close();
            conn.close();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Enter id and name");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Enter id in figures only");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}