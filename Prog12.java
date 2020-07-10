// An eg. of ResultSetMetaData. Accept a table name from user and display its structure i.e. fieldn name, type, width,
// etc.

import java.sql.*;

public class Prog12
{
    public static void main(String[] args)
    {
        try
        {
            String tablename = args[0];
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);

            Statement stmt = conn.createStatement();
            String sql = "select * from " + tablename;
            ResultSet rs = stmt.executeQuery(sql);
            //rs contains the records of some table in which we are not interested. So we create a ResultSet metadata
            //object which is created by calling getMetaData() on ResultSet object
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("FieldName\tFieldType\tFieldSize");
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
            {
                System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i) + "\t\t" + rsmd.getColumnDisplaySize(i));
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("ArrayIndexOutOfBoundsError");
        }
    }
}
