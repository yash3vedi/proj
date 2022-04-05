<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>

	<h5 align="center">
		<a href='<spring:url value="/customer/signup_cust"/>'>Customer SignUp</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/customer/login_cust"/>'>Login Customer</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/admin/login_adm"/>'>Login Admin</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/admin/signup_adm"/>'>Admin SignUp</a>
	</h5>
	
</body>
</html>