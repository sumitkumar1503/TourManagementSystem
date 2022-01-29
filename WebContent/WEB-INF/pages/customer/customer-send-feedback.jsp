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
  <jsp:include page="customer_header.jsp"/>
  <br><br><br>
  
  
    <frm:form  class="form-signin" modelAttribute="feed" method="POST"  style="
    padding-left: 30%;padding-right: 30%;">
      <img class="mb-4" src="<c:url value="/resources/images/logo.png"/>" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Send Feedback</h1> <br>
      <c:if test="${(msg ne null) && (msg != '')}">
      <p style="color:red;">** <c:out value="${msg}"/> **</p>
   </c:if>
       
      
       <label  class="sr-only">Feedback Name</label>
      <frm:textarea   path="feedback" class="form-control" rows = "5" cols = "30" placeholder="Write Your Feedback Here..." required="required" autofocus=""/><br>
      
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
     
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Send</button>
      
    </frm:form>
  
  
    <br><br><br>


<jsp:include page="customer_footer.jsp"/>
  

 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>


</body>
</html>















