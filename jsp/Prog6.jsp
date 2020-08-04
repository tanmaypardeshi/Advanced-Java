<%@ page language="java" info="Code to register new user" import="java.sql.*" %>

<html>
<head>
	<title>Regisration</title>
</head>

<body>
<% 
	String un = request.getParameter("username");
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info", "root", "java1234!");
	
	// 1st check whether the request username is available or not. If available,
	// go ahead to register him as user, otherwise reject and given him appropritate message
	
	
	String sql = "select * from accounts where username=?";
	
	PreparedStatement ps = conn.prepareStatement(sql);
	
	ps.setString(1, un);
	
	ResultSet rs = ps.executeQuery();
	
	// rejection 
	if(rs.next())
	{
%>
	<h2>Sorry <%= un %> already assigned. Please press back button and try different username.</h2>
	
<% 
	}
	else
	{
		String pwd = request.getParameter("password");
		
		// do not declare the objects again from previous scriplet block
		// otherwise we get compile error
		
		sql = "insert into accounts values (?,?,?)";
		
		ps = conn.prepareStatement(sql);
		
		ps.setString(1,un);
		ps.setString(2,pwd);
		ps.setInt(3,5000);	//min balance for new acct 
		
		ps.executeUpdate();	
		
		out.println("<h2>Username + " + un + " has been successfully registered</h2>");
	}
	rs.close();
	ps.close();
	conn.close();
%>
		
		
		
		
		
