<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>${requestScope.message}</h5>
	<h5>Hello , ${sessionScope.customer_details.customerName} </h5>
	<h5 align="center">
		<a href='<spring:url value="/customer/logout"/>'>Logout</a>
	</h5>
	<h5 align="center">
		<a href='<spring:url value="/appoint/get_apt"/>'>Fix Appointment</a>
	</h5>
	

</body>
</html>