<%@ page language="java" info="to accept and store data in a java bean" %>

<jsp:useBean id="udb" class="beans.UserData" scope="session"/>
<jsp:setProperty name="udb" property="username" param="un" />
<jsp:setProperty name="udb" property="mailid" param="emailid" />
<jsp:setProperty name="udb" property="salary" param="income"/>

<%
    /*Important - Use this feature if form parameters and bean fields have same name and same fields
    <jsp:setProperty name="udb" property="*" />
     */
%>


<h3>Data of user is stored in bean successfully!!!</h3>
<a href="Prog12b.jsp">To display user information</a>