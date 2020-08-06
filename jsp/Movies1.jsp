<%@ page language="java" import="java.util.Enumeration" %>

[<a href="Toys1.jsp">Shop for toys</a>]<p>

<table cellspacing=20>

<%
	String titles[] = {"Jurassic Park", "Iron Man 3", "Madgascar"};
	
	for(int i = 0; i < titles.length; i++)
	{
%>

<tr>
<td><%= titles[i] %>
<td><a href="Movies1.jsp?aitems=<%= titles[i] %>">Add to cart </a>
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
	{
		Object obj = e.nextElement();
		out.println("<li> " + obj);
		out.println("<a href='Toys1.jsp?ritems=" +   obj   + "'> Remove from cart</a>");		
	}
	// nextElement() returns attributes names
%>