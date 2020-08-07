<%@ page language="java" info="A jsp which will initialise a field of bean" %>

<jsp:useBean id="mb" class="beans.Message" scope="session" />
<jsp:setProperty name="mb" property="msg" value="Welcome to Databyte" />

<a href="Prog11b.jsp">Click to view state of the bean</a>
