<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>${requestScope.message}</h5>
	<h5>Hello , ${sessionScope.admin_details.adminName} </h5>
    
    <h5 align="center">
		<a href='<spring:url value="/admin/signup_adm"/>'>Admin SignUp</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/project/add_project"/>'>Add Project</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/property/add_property"/>'>Add Property</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/property/assign_property"/>'>Assign Property</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/admin/logout"/>'>Logout</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/property/delete"/>'>Delete Property</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/admin/list"/>'>List Property</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/admin/list_sold"/>'>List sold Property</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/admin/list_available"/>'>List Available Property</a>
	</h5>
	

</body>
</html>