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
			<caption>Delete Form</caption>
			<tr>
				<td>Property Id</td>
				<td><input type="number" name="Id" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete property" /></td>
			</tr>
		</table>
	</form>
</body>
</html>