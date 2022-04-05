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
				<td>Project Location</td>
				<td><input type="text" name="projectLocation" /></td>
			</tr>
			<tr>
				<td>Project Name</td>
				<td><input type="text" name="projectName" /></td>
			</tr>
			<tr>
				<td>PIN Code</td>
				<td><input type="text" name="projectPinCode" /></td>
			</tr>
			
			<tr>
				<td>Project Type</td>
				<td>
				<select name="projectType1" id="projectType1">
    					<option value="-1" selected>select..</option>
    					<c:forEach var="pType" items="${requestScope.projecttype}">
    					
      					<option value="${pType}">${pType}</option>
    					</c:forEach>
    					
				</select>
				</td>
				
			</tr>
			<tr>
				<td>Project Status</td>
				<td><select name="projectStatus1" id="projectStatus1">
    					<option value="-1" selected>select..</option>
    					<c:forEach var="pStatus" items="${requestScope.projectstatus}">
      					<option value="${pStatus}">${pStatus}</option>
    					</c:forEach>
    					
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Admit admin" /></td>
			</tr>
		</table>
	</form>
</body>
</html>