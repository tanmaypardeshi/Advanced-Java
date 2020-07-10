// A java program to connect to a backend database and display the records from 1 of its tables

import java.sql.*;

class Prog1
{
    public static void main(String[] args)
    {
        /* always start database programs with a "try" block to manage 2 checked exception */

        try
        {
            //establish a connection with the backend database using DSN
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    Connection conn = DriverManager.getConnection("jdbc:odbc:info");    //info is the name of DSN

            //create a statement object which will be used for storing queries
            Statement stmt = conn.createStatement();    //createStatement() is an instance method as the conn object
                                                        //is being used to invoke it

            //design the query
            String sql = "select * from empinfo";

            // execute the query and get the result in a java object called as ResultSet

            ResultSet rs = stmt.executeQuery(sql);

            //instance method of statement object which takes query as its parameter

            //before displaying records, display column headings manually

            System.out.println("Empid\tName\tSurname\tCity\tSalary");

            //now iterate in ResultSet object (collection) to display records 1 by 1

            while(rs.next())
                System.out.println(rs.getInt("empid") + "\t" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4));

            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

/*
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver") -> class keyword to define a class but Class is a predefined class in java
containing a static method "forName()" which accepts the name of the java side driver as its parameter. Here we are
using jdbc-odbc bridge driver(Type 1) which itself is a java class and resides in the package "sun.jdbc.odbc"
*/

/*
Connection conn = DriverManager.getConnection("jdbc:odbc:info") -> Here we are obtaining a reference to a connection
object. This reference is obtained by executing the static method "getConnection()" of the "DriverManager" class.
Note that we are not using the "new" keyword to create a "Connection" object because "Connection" is an interface
and interfaces and abstract classes cannot be instantiated using "new" keyword.
*/

/* Note: In advanced java, to create objects, rarely we will be using "new" keyword. This is because objects in
advanced java come with very complex settings. If we were to use new, we would have called parameterised constructor
and would have to specify these settings which are difficult. So by executing these static methods, we are creating
new objects with "predefined settings"
 */
