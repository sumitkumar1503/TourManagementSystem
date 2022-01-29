<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">


</head>

<body class="text-center" data-new-gr-c-s-check-loaded="14.1033.0"
	data-gr-ext-installed="">
	<jsp:include page="customer_header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">Your Bookings</h4>
				<br>
			</div>
			<table class="table table-hover table-bordered table-responsive-lg"
				id="dev-table">
				<thead class="thead-dark">
					<tr>
						<th> #</th>
						<th>Package Name</th>
						<th>Poster Pic</th>
						<th>Description</th>
						<th>Food</th>
						<th>Transportation</th>
						<th>Number Of Days</th>
						<th>Total Price</th>
						<th>Booking Date</th>
						
					</tr>
				</thead>

				<c:forEach varStatus="theCount" var="booking" items="${bookings}">
					<tr>
							<td>${ theCount.count}</td>
						<td>${booking.packages.packageName }</td>
						<td><img src="<c:url value="${booking.packages.posterImagePath}"/>"
							alt="Profile Pic" height="40px" width="40px" /></td>
						<td>${booking.packages.description }</td>
						<td>${booking.packages.food }</td>
						<td>${booking.packages.transportation }</td>
						<td>${booking.packages.numberOfDays }</td>
						<td>${booking.packages.totalPrice }</td>
						<td>${booking.date }</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="customer_footer.jsp" />

</html>