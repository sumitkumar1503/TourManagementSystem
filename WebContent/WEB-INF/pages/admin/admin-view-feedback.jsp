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
	<jsp:include page="admin_header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">Feedback By Customer</h4>
				<br>
			</div>
			<table class="table table-hover table-bordered table-responsive-lg"
				id="dev-table">
				<thead class="thead-dark">
					<tr>
						<th> #</th>
						<th>Customer Name</th>
						<th>Customer Mobile</th>
						<th>Feedback</th>
						<th>Received Date</th>
						
						
					</tr>
				</thead>

				<c:forEach varStatus="theCount" var="feed" items="${feeds}">
					<tr>
							<td>${ theCount.count}</td>
							<td>${feed.user.name }</td>
							<td>${feed.user.mobile }</td>
						<td>${feed.feedback }</td>
						
						
						<td>${feed.date }</td>
						
						
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
<jsp:include page="admin_footer.jsp" />

</html>