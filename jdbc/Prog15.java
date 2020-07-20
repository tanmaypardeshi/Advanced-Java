// Orders procedure

import  java.sql.*;
import  java.util.Scanner;

public class Prog15
{
	public static void main(String[] args)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a id:- ");
			int cid = sc.nextInt();

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "your_password");
			CallableStatement cstmt = conn.prepareCall("{ call get_order_by_id(?,?,?,?,?)}");
			cstmt.setInt(1,cid);
			cstmt.execute();

			int shipped_counter = cstmt.getInt(2);
			double shipped_sum = cstmt.getDouble(3);
			int cancelled_counter = cstmt.getInt(4);
			double cancelled_sum = cstmt.getDouble(5);

			System.out.println("Record for customer ID " + cid + " is:- ");
			System.out.println("No. of items shipped:- " + shipped_counter);
			System.out.println("Sum of items shipped:- " + shipped_sum);
			System.out.println("No. of items cancelled:- " + cancelled_counter);
			System.out.println("Sum of items canelled:- " + cancelled_sum);

			cstmt.close();
			conn.close();

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
