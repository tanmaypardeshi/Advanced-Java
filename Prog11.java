/* Metadata:- This indicates additional info about a database which may be useful for the developers. Here we are
going to study 2 types of meta data:
1. DatabaseMetaData
2. ResultSetMetaData
an eg. of DatabaseMetadata : This meta data will allow the programmer to access information like names and types of
tables present in DB, driver used, database product used, its version, username, etc. all from frontend i.e. Java
Program
 */

import java.sql.*;

public class Prog11
{
    public static void main(String[] args)
    {

        try {
            String databaseURL = "jdbc:ucanaccess://d://Code//Advanced-Java//empinfo.accdb";
            Connection conn = DriverManager.getConnection(databaseURL);

            //DatabaseMetaData is created by calling the getMetaData() of Connection object i.e conn
            DatabaseMetaData dbmd = conn.getMetaData();

            System.out.println("Databse used in backend is " + dbmd.getDatabaseProductName());
            System.out.println("Database version is " + dbmd.getDatabaseProductVersion());
            System.out.println("User logged in system is " + dbmd.getUserName());
            System.out.println("JDBC driver is " + dbmd.getDriverName());

            //to know names in DB
            String table_types[] = {"TABLE", "VIEW", "SYNONYM", "ALIAS"};

            /* These are different kinds of tables in DBs like user tables, system tables, view table (A view is a subset of
            certain rows and columns of given table). Synonym - Identical table, Alias - Another name assigned to same table
            to facilitate multiple queries on same table.
             */
            ResultSet rs = dbmd.getTables(null, null, null, table_types);

            /* The getTables() of DatabaseMetaData returns the information of all suc tables to a ResultSet object. The first
            three parameters are not applicable to MS-Access databases and hence kept null
             */
            System.out.println("TableName\tTableType");
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME") + "\t\t" + rs.getString("TABLE_TYPE"));
            }
            rs.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
