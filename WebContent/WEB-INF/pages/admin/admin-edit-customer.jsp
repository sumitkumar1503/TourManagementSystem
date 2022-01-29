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
  
  
    <frm:form  class="form-signin" modelAttribute="customer" method="POST" enctype="multipart/form-data" style="
    padding-left: 30%;padding-right: 30%;">
      <img class="mb-4" src="<c:url value="/resources/images/logo.png"/>" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Edit Customer</h1>
      <c:if test="${(msg ne null) && (msg != '')}">
      <p style="color:red;">** <c:out value="${msg}"/> **</p>
   </c:if>
       
      
       <label  class="sr-only">Customer Name</label>
      <frm:input type="text"  path="name" class="form-control" placeholder="Customer Name" required="required" autofocus=""/><br>
      
       <label  class="sr-only">Email</label>
      <frm:input type="text"  path="email" class="form-control" placeholder="Email" required="required"  autofocus=""/><br>
      
       <label  class="sr-only">Address</label>
      <frm:input type="text "  path="address" class="form-control" placeholder="Address" required="required" autofocus=""/><br>
      
      
      <label  class="sr-only">Mobile</label>
      <frm:input type="text"  path="mobile" class="form-control" placeholder="Mobile" required="required" autofocus=""/><br>
      
           
      <label  class="sr-only">Profile Image</label>
      <frm:input type="file"  path="profileimg" class="form-control" placeholder=""  autofocus=""/><br>
      
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
     
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Edit</button>
      
    </frm:form>
  
  
    <br><br><br>


<jsp:include page="admin_footer.jsp"/>
  

 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>


</body>
</html>















