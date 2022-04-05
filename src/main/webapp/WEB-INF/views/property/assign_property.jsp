<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> New Customer</title>
</head>
<body>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Assign Property Form</caption>
			
			
			<tr>
				<td>Project Id</td>
				<td><input type="number" name="projectId" /></td>
			</tr>
			<tr>
				<td>Property Id</td>
				<td><input type="number" name="propertytId" /></td>
			</tr>
			<tr>
				<td>Customer Id</td>
				<td><input type="number" name="customerId" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Admit admin" /></td>
			</tr>
		</table>
	</form>
</body>
</html>