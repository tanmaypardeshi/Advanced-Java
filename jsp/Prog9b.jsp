<%@ page language="java" info="Receive forwarded data from action tag" %>

<h3> Thanks <%= request.getParameter("un") %> for purchasing items <%= request.getParameter("items") %> </h3>


Delivery Period :- <i> <%= request.getParameter("del") %> </i> <p>

Payement :- <i> <%= request.getParameter("pay") %> </i> <p>
