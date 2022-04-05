<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> New Customer</title>
</head>
<body>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<caption>List Form</caption>
			
			<tr>
				<td> <c:forEach var="pType" items="${requestScope.properties}"><h1>${pType}</h1></c:forEach></td>
			</tr>
		</table>
		
	</form>
	
	<h5 align="center">
		<a href='<spring:url value="/admin/home"/>'>Return To Home</a>
	</h5>
	
	
</body>
</html>