<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  </head>





<body class="text-center" data-new-gr-c-s-check-loaded="14.1033.0" data-gr-ext-installed="" cz-shortcut-listen="true">
  <jsp:include page="header.jsp"/>
  <br>
  
    <form name='f'  action="login" method="post" class="form-signin" style="
    padding-left: 30%;padding-right: 30%;">
      <img class="mb-4" src="<c:url value="/resources/images/logo.png"/>" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
  <div class="error">
   <h6 style="color:red;">*** <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /> ***<h6><br>
  </div>
</c:if>
      
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="text"  name="username" class="form-control" placeholder="Email address" required="" autofocus=""><br>
      <label for="password" class="sr-only">Password</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
    
     <br><br>
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    
     <input  class="btn btn-lg btn-primary btn-block" type="submit">
    
      <p class="mt-5 mb-3 text-muted">Do not have account ? <a href="user_register">Register Account</a></p>
    </form>
  
  
  


<jsp:include page="footer.jsp"/>
  

 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>