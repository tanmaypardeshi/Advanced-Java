<%@ page language="java" info="to forward data to next jsp" %>

<%
	String un = request.getParameter("un");
	String items = request.getParameter("items");
	
%>

<b> Welcome to the website<p>
<a href="Prog8b.jsp?un=<%= un %>&items=<%= items %>&delivery=15 days">
Click here to confirm order </a>


