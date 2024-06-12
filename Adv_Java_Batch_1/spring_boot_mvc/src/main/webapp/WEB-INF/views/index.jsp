<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--import JSTL core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome 2 Spring boot based monolithic web app using JSP based
		view layer!!!!</h4>
	<h5>
		<c:url var="abc" value="/categories/list" />
		<a href="${abc}">List all Categories</a>
	</h5>
	<h5>
		<c:url var="abc" value="/user/login" />
		<a href="${abc}">User Login</a>
	</h5>
</body>
</html>