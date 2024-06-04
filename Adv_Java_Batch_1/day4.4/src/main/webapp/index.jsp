<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<h4>
		Welcome 2 JSP !!!! , Server TS
		<%=LocalDateTime.now()%></h4>
	<h5>
		<a href="comments.jsp">Test Comments</a>
	</h5>
</body>
</html>