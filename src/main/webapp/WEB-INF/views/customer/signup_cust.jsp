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
<h5 align="center"  style="color: red;">${requestScope.err_message}</h5>
	<h5>${requestScope.message}</h5>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Customer Form</caption>
			<tr>
				<td>Name</td>
				<td><input type="text" name="customerName" /></td>
			</tr>
			<tr>
				<td>Co-applicant Name</td>
				<td><input type="text" name="customerCoapplicantName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="customerpassword" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="customerEmail" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="customerAddress" /></td>
			</tr>
			<tr>
				<td>Mobile No.</td>
				<td><input type="text" name="customerMobile" /></td>
			</tr>
			<tr>
				<td>Adhar No.</td>
				<td><input type="text" name="customerAdhar" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Admit Customer" /></td>
			</tr>
		</table>
	</form>
</body>
</html>