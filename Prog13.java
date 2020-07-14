/* A java program to access mysql database "custinfo" and display its records. MYSQL databases do not require DSN.
   However, we will require a driver on database side to convert the request of jdbc driver. To facilitate this, you need
   to download the mysqldriver for java and set it in a special environment variable called as "classpath". This driver
   is in the form of "jar" file i.e. java archive file. Its a good habit to store all such drivers in a particular path. We
   have kept this driver in following path C:\Program Files(x86)\java\jre7\lib\ext\mysql-connector-java-5.0.8-bin.jar
 */

import java.sql.*;

class Prog13
{
    public static void main(String[] args)
    {
        try
        {
            // only first 2 lines will change, rest of code is same as that for ms-access
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "your_username", "your_password");
            // localhost is tha name of the server on which mysql is installed and is prividing service through a "port"
            // with unique number 3306(By default, can be a different one while you install mysql). There are
            // 0-65536 parts available, out of which 0-1024 are reserved for standard services eg. 80-http, 25-email,etc
            Statement stmt = conn.createStatement();
            String sql = "select * from custinfo";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Customer Id\tCustomer Name");
            while(rs.next())
            {
                System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2));
            }
            rs.close();
            stmt.close();
            conn.close();


        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}