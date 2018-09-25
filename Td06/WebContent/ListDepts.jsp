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
	List<Department> depts = (List<Department>) request.getAttribute("liste_depts");
%>

	<table border=1>
  <%
 	for(Department d : depts){
  %>
		<tr>
			<% 
				String queryParams = "deptID=" + d.getNumDept();
			    queryParams +="&deptName=" + d.getNameDept();
			%>
			<td><%=d.getNameDept() %></td>
			<td><a href="Ex3StudentServlet?<%=queryParams%>">Students</a></td>
		</tr>
  <%
 	}
  %>
	</table>

</body>
</html>