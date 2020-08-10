<%@ page language="java" info="to accept and store data in a java bean" %>

<jsp:useBean id="udb" class="beans.UserData" scope="session"/>

Username - <jsp:getProperty name="udb" property="username"/>
Emailid - <jsp:getProperty name="udb" property="mailid"/>
Salary - Rs.<jsp:getProperty name="udb" property="salary"/>