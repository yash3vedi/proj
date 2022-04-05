<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 style="color:red;">${requestScope.message}</h5>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Customer Login</caption>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Customer Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>