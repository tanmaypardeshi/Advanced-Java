<%@ page language="java" info="Display hit counts" %>

<%!
	int cntr = 0;
	
	int pageHit()
	{
		cntr++;
		return cntr;
	}
	// important - this should be global variable only. If declared in scriplet,
	// it will become local to _jspSrrvice() which is executed on user to user
	// bases and hence will reset cntr for every request
	
%>
<h2> Welcome visitor no <%= pageHit() %></h2>
