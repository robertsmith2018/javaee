<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.qc.cgodin.model.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>

	<%
	String deptName = request.getParameter("deptName");
	int deptID = Integer.parseInt(request.getParameter("deptID"));
	List<Student> students = (List<Student>) request.getAttribute("liste_students");
%>
<h1>Student List for the department <%=deptName %> </h1>
            <% 
				String queryParams = "deptID=" + deptID;
			    queryParams +="&deptName=" + deptName;
			%>
<p><a href="Ex3AddStudentServlet?<%=queryParams%>">Add New Student</a></p>

	<table border=1>
  <%
 	for(Student s : students){
  %>
		<tr>
			<td><%=s.getNameStud() %></td>
			
		</tr>
  <%
 	}
  %>
	</table>

</body>
</html>