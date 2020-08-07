<%@ page language="java" info="to print contents of bean object" %>

<!-- Instantiate the bean object -->

<jsp:useBean id="ib" class="beans.Item" />

Details of item of bean are <br>
Item ID:- <jsp:getProperty name="ib" property="id"/><br>
Name:- <jsp:getProperty name="ib" property="name"/><br>
Rate:- <jsp:getProperty name="ib" property="rate"/><br>