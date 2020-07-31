<%@ page language="java" info="jsp with scriples and expressions" import="java.util.Date" %>

<html>
	<body>
	
		<% 
			//a scriplet with variables and expressions
			int principal = 10000, no_years = 2;
			double rate = 5.25, si;
			
			si = principal * rate * no_years / 100;
		%>
		<h3> An investment of Rs. <%= principal %> for a period of
			<%= no_years %> yeas at <%= rate %>% will fetch SI of Rs. <%= si %><p>
			
			Simple Interest is Rs. <%= principal*rate*no_years/100 %><p>
			
			Today is <%= new Date() %>
		</h3>
		
	
	</body>
</html>
