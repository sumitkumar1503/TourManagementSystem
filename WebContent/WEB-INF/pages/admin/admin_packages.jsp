<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin || TMS</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <style type="text/css">
      a:link {
        text-decoration: none;
      }
  
      .order-card {
        color: rgb(255, 255, 255);
      }
  
      .bg-c-blue {
        background: #04868f;
      }
  
      .bg-c-green {
        background:#4C51BF;
      }
  
      .bg-c-yellow {
        background: #F56565;
      }
  
      .bg-c-pink {
        background: #663a30;
      }
  
  
      .card {
        
        -webkit-box-shadow: 0 1px 2.94px 0.06px rgba(4, 26, 55, 0.16);
        box-shadow: 0 1px 2.94px 0.06px rgba(4, 26, 55, 0.16);
        border: 1px solid black;
        margin-bottom: 30px;
        -webkit-transition: all 0.3s ease-in-out;
        transition: all 0.3s ease-in-out;
      }
  
      .card .card-block {
        padding: 25px;
      }
  
      .order-card i {
        font-size: 26px;
      }
  
      .f-left {
        float: left;
      }
  
      .f-right {
        float: right;
      }
      header {
      left: 0px;
      right: 0px;
    }
    </style>
  </head>

<body>
<jsp:include page="admin_header.jsp"/><br><br><br><br>
  <div class="container">

    
    <div class="row">
      <div class="col-md-4 col-xl-6">
        <div style="background-color:red;" class="card bg-c-green order-card">
          <div class="card-block">
            <h6 class="m-b-20"> <a href="<c:url value="/admin/admin-view-package"/>" style="text-decoration: none;color:white;">View Package</a> </h6>
            <h2 class="text-right"><i  class="fa fa-eye f-left"></i></span></h2>
            
          </div>
        </div>
      </div>
  
      <div class="col-md-4 col-xl-6">
        <div style="background-color:green;" class="card bg-c-green order-card">
          <div class="card-block">
            <h6 class="m-b-20"><a href="<c:url value="/admin/admin-add-package"/>" style="text-decoration: none;color:white;">Add Package</a> </h6>
            <h2 class="text-right"><i class="fa fa-plus f-left"></i></h2>
            
          </div>
        </div>
      </div>
 

      
    </div>

    <br>
   

  

  </div>


<br><br><br><br><br><br><br><br><br>
<jsp:include page="admin_footer.jsp"/>
<script src="http://netdna.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</body>
</html>

    