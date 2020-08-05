<%@ page language="java" info="Example of jsp action tag" %>

<%
	String priv_mem = request.getParameter("priv_mem");
	if(priv_mem != null)
	{
%>
<jsp:forward page="Prog9b.jsp">
<jsp:param name="del" value="immediately" />
<jsp:param name="pay" value="within 15 days" />
</jsp:forward>

<%
	}
	else
	{
%>
<jsp:forward page="Prog9b.jsp">
<jsp:param name="del" value="1 to 2 days" />
<jsp:param name="pay" value="within 30 days" />
</jsp:forward>

<%
	}
%>
