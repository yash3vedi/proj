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
			<caption>admin Form</caption>
			<tr>
				<td>Name</td>
				<td><input type="text" name="adminName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="adminEmail" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="adminPassword" /></td>
			</tr>
			
			<tr>
				<td>Mobile No.</td>
				<td><input type="text" name="adminMobile" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Admit admin" /></td>
			</tr>
		</table>
	</form>
</body>
</html>