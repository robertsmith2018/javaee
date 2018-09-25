<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.qc.cgodin.model.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee list</title>
</head>
<body>
<h1>Employee List - Coded by Rabih Assaker</h1>
	<%
		List<Employee> emps = (List<Employee>) request.getAttribute("liste_emps");
	%>

	<table border=1>
  <%
 	for(Employee emp : emps){
  %>
  	
		<tr>
	
			<td><%=emp.getId() %></td>
			<td><%=emp.getName() %></td>
			<td><%=emp.getSalary() %></td>
			
		</tr>

  <%
 	}
  %>
  		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="List Of departments" onClick="window.location='./ListDepts.jsp';"/></td>
			<td><input type="submit" value="increase salaries" onClick="window.location='./salaryIncrease';"/></td>
		</tr>
	</table>

</body>
</html>