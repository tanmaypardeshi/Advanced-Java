<%@ page language="java" info="an eg. of jsp include tag" %>

<html>
<body>
	<jsp:include page="Header.jsp">
	<jsp:param name="dept" value="Software Division" />
	<jsp:param name="telno" value="2546-1563" />
	</jsp:include>
	
	There are the contents of the software department
	
	<a href="Hw.jsp"> Go to hardware page </a>
	
</body>
<html>
