// same as Prog14 but with a few errors resolved

import java.sql.*;

public class Prog14new
{
	public static void main(String[] args)
	{
		try
		{
			int cid = Integer.parseInt(args[0]);
			String cname = args[1];

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "your_password");
			CallableStatement cstmt = conn.prepareCall("{call chgdata2(?,?,?)}");

			// chgdata2 procedure can have 3 parameters. 2 IN and 1 OUT parameter which will
			// contain the no. of rows affected by update query. Set the values for IN paramters.

			cstmt.setInt(1,cid);
			cstmt.setString(2,cname);

			cstmt.execute();
			// if sql stored procedure is containing multiple queries of different types for example select, insert,
			// update, delete, etc. then this is a work around. Do not use either the executeQuery() or executeUpdate()

			int count = cstmt.getInt(3);
			// we get 1 if record to be updated is found otherwise returns 0
			//count will contain the number of records affected by query validation

			System.out.println("Value of count is " + count);

			if(count == 0)
				System.out.println("Record not updated because record with id " + cid + " not found");
			else
				System.out.println("Record updated successfully");

			// to display records
			ResultSet rs = cstmt.getResultSet();

			System.out.println("Customer Id\tCustomer Name");
			while(rs.next())
				System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2));

			rs.close();
			cstmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
