<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Employee</title>
</head>
<body>


<form method="POST" action="addEmployeeServlet" >
 Employee Name:<br>
  <input type="text" name="empName">
  <br>
  Salary :<br>
  <input type="text" name="empSalary">
  <br>
  Department :<br>
  <input type="text" name="empDepartment">
  <br>
    
  <input type="submit" value="Submit">
</form>

</body>
</html>