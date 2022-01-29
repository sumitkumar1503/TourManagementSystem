<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link  href="<c:url value="/resources/css/all.css"/>" rel="stylesheet"> <!--load all styles -->

</head>
<body>
<jsp:include page="header.jsp"/>



  <div id="carouselExampleIndicators" style="margin-top: 0%;" class="carousel slide" data-ride="carousel">

    <div class="carousel-inner">
      <div class="carousel-item active">
        <img class="d-block w-100 cor" height="400px" width="100%" src="<c:url value="/resources/images/maldives.jpg"/>" alt="First slide">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100 cor" height="400px" width="100%" src="<c:url value="/resources/images/tajmahal.jpg"/>" alt="Second slide">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100 cor" height="400px" width="100%" src="<c:url value="/resources/images/uttarakhand.jpg"/>" alt="Third slide">
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>



<jsp:include page="footer.jsp"/>
</body>
</html>