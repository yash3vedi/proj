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
			<caption>Appointment Form</caption>
			<tr>
				<td>Appointment Date:</td>
				<td><input type="date" name="aptdate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Appointment Request" /></td>
			</tr>
		<h5 align="center">
		<a href='<spring:url value="/customer/home"/>'>Return to home</a>
		</h5>
		</table>
	</form>
	${requestScope.appointment}
</body>
</html>