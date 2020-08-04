<%@ page language="java" info="to get data from request object" %>

<%
	String un = request.getParameter("un");
	String items = request.getParameter("items");
	String delivery = request.getParameter("delivery");
	
%>

<b>Thanks <%= un %> for purchasing <%= items %><p>
Delivery = <%= delivery %>

