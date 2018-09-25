<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Bonjour: <%=request.getParameter("fullname") %></p>
<p>Vous avez <%=request.getAttribute("age") %> ans</p>
</body>
</html>