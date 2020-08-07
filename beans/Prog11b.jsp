<%@ page language="java" info="A jsp which will display a field of bean" %>

<jsp:useBean id="mb" class="beans.Message" scope="session" />

Mesage in the bean contains:- <br>
<jsp:getProperty name="mb" property="msg"/>