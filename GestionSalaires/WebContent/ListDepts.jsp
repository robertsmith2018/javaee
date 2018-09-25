<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.qc.cgodin.model.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department list</title>
</head>
<body>
<h1>Department List</h1>
	<%
	//List<Department> depts = (List<Department>) request.getAttribute("liste_depts");
	
	String[] depts = { "Software", "Graphic", "IT" };
%>

	<table border=1>
  <%
 	
 		
	for( int i=0; i<depts.length; i++)
	{
	    String s1 = depts[i];
	  
	
 	
  %>
		<tr>
			<% 
				String queryParams = "deptName=" + s1;
			   
			%>

			<td><%= s1 %></td>
			<td><a href="EmployeesServlet?<%=queryParams%>">List Of Employees</a></td>
			
		</tr>
  <%
 	}
  %>
	</table>

</body>
</html>