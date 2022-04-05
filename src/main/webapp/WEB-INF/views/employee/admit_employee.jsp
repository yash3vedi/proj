<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> New Employee</title>
</head>
<body>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Employee Form</caption>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="cgpa" value="${sessionScope.name_ofcourse }" /><span style="color: red;">${requestScope.err_message}</span></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="date" name="dob" /> <span style="color: red;">${requestScope.err_message}</span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Admit Employee" /></td>
			</tr>
		</table>
	</form>
</body>
</html>