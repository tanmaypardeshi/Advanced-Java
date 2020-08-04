<%@ page language="java" info="an eg. of jsp include tag" %>

<html>
<body>
	<jsp:include page="Header.jsp">
	<jsp:param name="dept" value="Hardware Division" />
	<jsp:param name="telno" value="2546-1563" />
	</jsp:include>
	
	There are the contents of the hardware department
	
	<a href="Sw.jsp"> Go to software page </a>
	
</body>
<html>
