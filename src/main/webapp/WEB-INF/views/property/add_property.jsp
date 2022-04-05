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
			<caption>Customer Form</caption>
			<tr>
				<td>Property Status</td>
				<td><select name="propertyStatus1" id="propertyStatus1">
    					<option value="-1" selected>select..</option>
    					<c:forEach var="prtStatus" items="${requestScope.propertystatus}">
    					
      					<option value="${prtStatus}">${prtStatus}</option>
    					</c:forEach>
    					
				</select></td>
			</tr>
			<tr>
				<td>Property Area</td>
				<td><input type="text" name="propertyArea" /></td>
			</tr>
			<tr>
				<td>Project Id</td>
				<td><input type="number" name="projectId" /></td>
			</tr>
			
			
			<tr>
				<td colspan="2"><input type="submit" value="Admit admin" /></td>
			</tr>
		</table>
	</form>
</body>
</html>