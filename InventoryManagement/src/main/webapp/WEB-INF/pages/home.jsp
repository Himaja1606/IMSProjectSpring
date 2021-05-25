<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	Home Page .....
	<input type="submit" value="Add Customer"
		onclick="window.location.href='register'" />
	<br>
	<br>
	<br> ${NOTIFICATION}



	<div>
		<table class="table">
			<thead>

				<tr>
					<th>CID</th>
					<th>CNAME</th>
					<th>PHONENO</th>
					<th>Email</th>
					<th>PassWord</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${cuslist}">
					<tr>
						<td><c:out value="${customer.customerId}"></c:out></td>
						<td><c:out value="${customer.customerName}"></c:out></td>
						<td><c:out value="${customer.customerPhoneno}"></c:out></td>
						<td><c:out value="${customer.customerEmail}"></c:out></td>
						<td><c:out value="${customer.customerPassword}"></c:out></td>
						<td><a
							href="edit?customerId=${customer.customerId}&customerName=${customer.customerName}&customerPhoneno=${customer.customerPhoneno}&customerEmail=${customer.customerEmail}&customerPassword=${customer.customerPassword}">EDIT</a></td>
						<td><a href="delete?customerId=${customer.customerId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>