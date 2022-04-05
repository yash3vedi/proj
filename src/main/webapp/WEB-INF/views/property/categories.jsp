<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses List</title>
</head>
<body>
	<h3 style="color=green;">${requestScope.message}</h3>
	<h3 style="color=green;">${sessionScope.message}</h3>
	<form>
		<table style="background-color: lightgrey; margin: auto; border: 1px">
			<tr>
				<th>Category Name</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach var="list" items="${requestScope.category_list}">
				<tr>
					<td>${list.categoryName}</td>
					<td><a
						href='<spring:url value="/category/delete?category_name=${list.categoryName}"/>'>Delete</a></td>
					<td><a
						href='<spring:url value="/employee/admit_employee?categoryID=${list.id}"/>'>Admit
							Employee</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>