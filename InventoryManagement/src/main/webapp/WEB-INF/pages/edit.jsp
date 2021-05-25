<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h3>Edit your record here</h3>
		<div class="row">
			<div class="col-md-4">
				<form action="update" method="get">

					<div class="form-group">
						<label for="lblcustomerId">Customer ID</label> <input type="text"
							class="form-control" id="lblcustomerId" name="customerId"
							placeholder="Enter CID" value="${param.customerId}" />
					</div>
					<div class="form-group">
						<label for="lblcustomerName"> Name</label> <input type="text"
							class="form-control" id="lblcustomerName" name="customerName"
							placeholder="Enter Name" value="${param.customerName}" />
					</div>
					<div class="form-group">
						<label for="lblcustomerPhoneno">Contact</label> <input
							type="number" class="form-control" id="lblcustomerPhoneno"
							name="customerPhoneno" placeholder="Enter phone number"
							value="${param.customerPhoneno}" />
					</div>
					<div class="form-check-inline">
						<label for="lblcustomerEmail">Email</label> <input type="text"
							class="form-control" id="lblcustomerEmail" name="customerEmail"
							placeholder="Enter valid Email" value="${param.customerEmail}" />

					</div>
					<button type="submit" value="update" class="btn btn-primary">Update
						Customer</button>
				</form>
			</div>

		</div>

	</div>
</body>
</html>