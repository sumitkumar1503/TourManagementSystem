<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >

  </head>





<body class="text-center" data-new-gr-c-s-check-loaded="14.1033.0" data-gr-ext-installed="" >
  <jsp:include page="admin_header.jsp"/>
  <br><br><br>
  
  
    <frm:form  class="form-signin" modelAttribute="packages" method="POST" enctype="multipart/form-data" style="
    padding-left: 30%;padding-right: 30%;">
      <img class="mb-4" src="<c:url value="/resources/images/logo.png"/>" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Add Package</h1>
      <c:if test="${(msg ne null) && (msg != '')}">
      <p style="color:red;">** <c:out value="${msg}"/> **</p>
   </c:if>
       
      
       <label  class="sr-only">Package Name</label>
      <frm:input type="text"  path="packageName" class="form-control" placeholder="Package Name" required="required" autofocus=""/><br>
      
       <label  class="sr-only">Description</label>
      <frm:input type="text"  path="description" class="form-control" placeholder="Description" required="required"  autofocus=""/><br>
      
       <label  class="sr-only">Number Of Days</label>
      <frm:input type="number"  path="numberOfDays" class="form-control" placeholder="Number Of Days" required="required"  autofocus=""/><br>
      
      
      <label  class="sr-only">Food</label>
      <frm:input type="text"  path="food" class="form-control" placeholder="Food" required="required"  autofocus=""/><br>
      
      <label class="sr-only">Transportation</label>
      <frm:input type="text"  path="transportation" class="form-control" placeholder="Transportation" required="required"  /><br>
     
     <label  class="sr-only">Total Price</label>
      <frm:input type="number"  path="totalPrice" class="form-control" placeholder="Total Price" required="required" autofocus=""/><br>
     
      <label  class="sr-only">Poster Image</label>
      <frm:input type="file"  path="posterImage" class="form-control" placeholder="" required="required"  autofocus=""/><br>
      
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
     
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
      
    </frm:form>
  
  
    <br><br><br>


<jsp:include page="admin_footer.jsp"/>
  

 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>


</body>
</html>















