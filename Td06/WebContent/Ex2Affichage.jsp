<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="ca.qc.cgodin.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Product> products = (List<Product>) request.getAttribute("listeProduits");
%>

	<table border=1>
  <%
 	for(Product p : products){
  %>
		<tr>
			<td><%=p.getNameProd() %></td>
			<td><%=p.getPriceProd() %></td>
		</tr>
  <%
 	}
  %>
	</table>
</body>
</html>