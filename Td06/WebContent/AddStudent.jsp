<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Student</title>
</head>
<body>
<%
    //on recupere les deux parametres envoyes par le lien hypertexte
	String deptID = request.getParameter("deptID");
	String deptName = request.getParameter("deptName");
%>

<form method="POST" action="Ex3AddStudentServlet" >
 Student Name:<br>
  <input type="text" name="studentName">
  <br>
   Department Name <br>
   <input type="text" name="deptName" value="<%=deptName%>" disabled="disabled">
   <input type="hidden" name="deptID" value="<%=deptID%>">
   <br> <br>
    
  <input type="submit" value="Submit">
</form>

</body>
</html>