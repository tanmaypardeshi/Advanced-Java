<%@ page language="java" import="java.util.Enumeration" %>

[<a href="Movies.jsp">Shop for movies</a>]<p>

<table cellspacing=20>

<%
	String titles[] = {"Lego", "RC car", "Dolls"};
	
	for(int i = 0; i < titles.length ; i++)
	{
%>

<tr>
<td><%= titles[i] %>
<td><a href="Toys.jsp?aitems=<%= titles[i] %>">Add to cart </a>
<td><a href="Toys.jsp?ritems=<%= titles[i] %>">Remove from cart </a>
</tr>

<%
	}
%>
</table>

<h3> Contents of shopping cart</h3>
<hr>

<ul type="square">

<%
	String aitems = request.getParameter("aitems");
	String ritems = request.getParameter("ritems");
	
	if(aitems != null)
	{
		// add this item session object 
		session.setAttribute(aitems,aitems);
		//name and value are same values
	}
	if(ritems != null)
	{
		// remove this item from session object
		session.removeAttribute(ritems);
	}
	
	/*
		now display the contents of session objects unfortunately, the session
		object (collection) doesn't have its own method to display its content.
		So we obtain a reference to each name is an Enumeration and display corresponding values
	*/
	
	Enumeration e = session.getAttributeNames();
	
	// as attribute names and its values is same, as can simple display attribute names
	
	while(e.hasMoreElements())	//boolean
		out.println("<li> " + e.nextElement());
	// nextElement() returns attributes names
%>
