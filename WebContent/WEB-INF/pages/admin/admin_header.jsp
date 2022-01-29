<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin || TMS</title>


<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<style type="text/css">
.bs-example {
	margin: 0px;
}

.navbar-brand {
	font-size: 20px;
	font-family: sans-serif;
}
</style>
</head>
</head>
<body>

	<div class="bs-example">
		<nav class="navbar navbar-expand-md navbar-dark fixed-top"
			style="background: #0000ff;">
			<a href="<c:url value="/admin/admindashboard"/>" class="navbar-brand">Tour Management System</a>
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-between"
				id="navbarCollapse">
				<div class="navbar-nav">
					<a href="<c:url value="/admin/admindashboard"/>" class="nav-item nav-link">Dashboard</a>
					<a href="<c:url value="/admin/admin-view-customer"/>" class="nav-item nav-link">Customer</a> <a
						href="<c:url value="/admin/admin-view-booking"/>" class="nav-item nav-link">Booking</a> <a
						href="<c:url value="/admin/admin-packages"/>" class="nav-item nav-link">Packages</a> <a
						href="<c:url value="/admin/admin-view-feedback"/>" class="nav-item nav-link">Feedbacks</a>
				</div>

				<div class="navbar-nav navbar-right">
					<a href="<c:url value="/logout"/>" class="nav-item nav-link">LOGOUT</a>
				</div>

			</div>
		</nav>
	</div>



</body>
</html>