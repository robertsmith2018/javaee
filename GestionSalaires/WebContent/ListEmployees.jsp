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
	<%
	 	String deptName = request.getParameter("deptName");
		List<Employee> emps = (List<Employee>) request.getAttribute("liste_emps");
	%>
<h1>Employee List for the department <%=deptName %> </h1>

<p><a href="addEmployeeServlet">Add New Student</a></p>
           
	<table border=1>
  <%
 	for(Employee emp : emps){
  %>
		<tr>
	
			<td><%=emp.getId() %></td>
			<td><%=emp.getName() %></td>
			
		</tr>
  <%
 	}
  %>
	</table>

</body>
</html>