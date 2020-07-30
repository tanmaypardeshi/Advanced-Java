<html>

<head>
	<title>My first JSP</title>
<head>

<body>
	<h2> An eg. of static and dynamic portions </h2>
	
	<!-- This is comment in static part of JSP -->
	
	<% 
		// comment inside scriptlet
		
		String name = "Tanmay";
		
		// print hello 5 times
		
		for(int i=0;i<5;i++)
		{
	%>
	<b><i>hello</b></i><p>
	<%
		}
		out.println("My name is " + name);
		
		// out is predefined object which represents std o/p stream
		
	%>
	<p>
	My name is <%= name %>
</body>
</html>
