<%@ page language="java" info="An eg. of declarations " %>

<html>
	<body>
		<%!
			int x = 10;	//global variable
			String myMethod(String name)
			{
				// error, var "out" not known. Do not use your method for printing
				// because "out" is JSP implicit object
				// out.println("Value of x is " + x);
				x++;
				return "Welcome " + name;
			}
		%>
		
		<h3>Before calling myMethod(), x contains <%= x %><p>
		<%= myMethod("Tanmay") %><p>
		After calling myMethod(), x contains <%= x %><p></h3>
		
	</body>
</html>
		
		
