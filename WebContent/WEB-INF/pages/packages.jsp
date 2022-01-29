<%@ page language="java"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  href="<c:url value="/resources/css/all.css"/>" rel="stylesheet"> <!--load all styles -->
<style type="text/css">

 button {
      border: none;
      outline: 0;
      display: inline-block;
      padding: 8px;
      color: white;
      background-color: rgb(175 51 51);
      text-align: center;
      cursor: pointer;
      width: 100%;
      font-size: 18px;
    } 
</style>
</head>
<body>
<jsp:include page="header.jsp"/>


<c:if test="${packages.size() > 0}">
<br>
<h4 class="text-center" style="color:red;">Package Available To Book</h4>
<br>


 <div class="container">
    <div class="row">
      <c:forEach varStatus="theCount" var="pack" items="${packages}">

      <div class="col-xl col-sm-4">
        <div class="card">
          <div class="card-header bg-primary text-center" style="color: white;"><strong>${pack.packageName}
            </strong></div>
          <img src="<c:url value="${pack.posterImagePath}"/>" height="200px" width="200px" class="card-img-top" alt="...">
          <div class="card-body">

            <p class="card-text text-center">${pack.description}</p>
            <ul class="list-group list-group-flush">
    <li class="list-group-item">Number Of Days : ${pack.numberOfDays }</li>
    <li class="list-group-item">Food : ${pack.food }</li>
    <li class="list-group-item">Transportation : ${pack.transportation }</li>
    <li class="list-group-item">Cost : ${pack.totalPrice }</li>
  </ul>
            <p><a style="text-decoration: none;color: white;" href="<c:url value="/customer/customer-book-package">
									<c:param name="id" value="${pack.id}"/>
								</c:url>"><button>Book Now</button></a>

          </div>
        </div>
      </div>

	<c:if test="${ theCount.count % 3 eq 0}">
	</div><br>
	 <div class="row">
	 <br><br>
	</c:if>
 
      </c:forEach>

    </div>
    <br>


    <br>

</c:if>
<c:if test="${packages.size() == 0}">
<br><br>
<h4 class="text-center" style="color:red;">No Package Available</h4>
</c:if>


 






</body>

</html>