<%@ page language="java" info="jsp to receive and process html parameters" %>

<html>
<head>
	<title>Welcome</title>
</head>

<body>
<% 
	String fn = request.getParameter("fn");
	
	//request is an implicit object of jsp
	
	String gender = request.getParameter("gender");
	
	String status;
	
	if(gender.equalsIgnoreCase("male"))
		status = "MR. ";
	else
		status = "MS. ";

%>		
	<h2>Welcome <%= status %> <%= fn %> to the website.
</body>
</html>
