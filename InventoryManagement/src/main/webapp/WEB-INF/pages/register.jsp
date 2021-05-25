<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h3>Inventory Management System</h3>
		<a href="login">Login here</a>

		<div class="row">
			<div class="col-md-4">
				<form action="register" method="post">


					<div class="form-group">
						<label for="lbcustomerName"> Name</label> <input type="text"
							class="form-control" id="lbcustomerName" name="txtcustomerName"
							placeholder="Enter First Name" />
					</div>
					<div class="form-group">
						<label for="lblcustomerPhoneno">Contact</label> <input
							type="number" class="form-control" id="lblcustomerPhoneno"
							name="customerPhoneno" placeholder="Enter contact number" />
					</div>

					<div class="form-group">
						<label for="lblcustomerEmail">Email</label> <input type="text"
							class="form-control" id="lblcustomerEmail"
							name="txtcustomerEmail" placeholder="Enter Email" />
					</div>


					<div class="form-group">
						<label for="lblcustomerPassword">Password</label> <input
							type="text" class="form-control" id="lblcustomerPassword"
							name="txtcustomerPassword" placeholder="Enter Password" />
					</div>

					<button type="submit" class="btn btn-primary">Register
						Customer</button>
				</form>
			</div>

		</div>

	</div>


</body>
</html>