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
				<h6 class="panel-title">Packages</h6>
				<br>
			</div>
			<table class="table table-hover table-bordered table-responsive-lg"
				id="dev-table">
				<thead class="thead-dark">
					<tr>

						<th>Name</th>
						<th>Poster</th>
						<th>Days</th>
						<th>Transportation</th>
						<th>Food</th>
						<th>Total Price</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<c:forEach varStatus="theCount" var="pack" items="${packages}">
					<tr>

						<td>${pack.packageName }</td>
						<td><img src="<c:url value="${pack.posterImagePath}"/>"
							alt="Profile Pic" height="40px" width="40px" /></td>
						<td>${pack.numberOfDays }</td>
						<td>${pack.transportation }</td>
						<td>${pack.food }</td>
						<td>${pack.totalPrice }</td>
						<td><a class="btn btn-danger btn-xs"
							href="
								<c:url value="/admin/admin-edit-package">
									<c:param name="id" value="${pack.id}"/>
								</c:url>
							"><span
								style="font-size: 0.9em; color: white;"> <i
									class="fas fa-edit"></i>
							</span></a></td>
							
							
							<td><a class="btn btn-danger btn-xs"
							href="
								<c:url value="/admin/admin-delete-package">
									<c:param name="id" value="${pack.id}"/>
								</c:url>
							"><span
								style="font-size: 0.9em; color: white;"><i class="fas fa-trash"></i>
							</span></a></td>
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