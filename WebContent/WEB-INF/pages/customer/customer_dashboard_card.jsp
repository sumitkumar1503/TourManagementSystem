<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
 <!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title></title>

  <style media="screen">
    .market-update-block {
      padding: 2em 2em;
      background: #999;
    }

    .market-update-block h3 {
      color: #fff;
      font-size: 2.5em;
      font-family: 'Carrois Gothic', sans-serif;
    }

    .market-update-block h4 {
      font-size: 1.2em;
      color: #fff;
      margin: 0.3em 0em;
      font-family: 'Carrois Gothic', sans-serif;
    }

    .market-update-block p {
      color: #fff;
      font-size: 0.8em;
      line-height: 1.8em;
    }

    .market-update-block.clr-block-1 {
      background: #3b983a;
      margin-right: 0.8em;
      box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
      transition: 0.5s all;
      -webkit-transition: 0.5s all;
      -moz-transition: 0.5s all;
      -o-transition: 0.5s all;
    }

    .market-update-block.clr-block-2 {
      background: #FC8213;
      margin-right: 0.8em;
      box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
      transition: 0.5s all;
      -webkit-transition: 0.5s all;
      -moz-transition: 0.5s all;
      -o-transition: 0.5s all;
    }

    .market-update-block.clr-block-3 {
      background: #1355f9;
      box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
      transition: 0.5s all;
      -webkit-transition: 0.5s all;
      -moz-transition: 0.5s all;
      -o-transition: 0.5s all;
    }

    .market-update-block.clr-block-1:hover {
      background: #3C3C3C;
      transition: 0.5s all;
      -webkit-transition: 0.5s all;
      -moz-transition: 0.5s all;
      -o-transition: 0.5s all;
    }

    .market-update-block.clr-block-2:hover {
      background: #3C3C3C;
      transition: 0.5s all;
      -webkit-transition: 0.5s all;
      -moz-transition: 0.5s all;
      -o-transition: 0.5s all;
    }

    .market-update-block.clr-block-3:hover {
      background: #3C3C3C;
      transition: 0.5s all;
      -webkit-transition: 0.5s all;
      -moz-transition: 0.5s all;
      -o-transition: 0.5s all;
    }


    .market-update-right i.fa.fa-globe {
      font-size: 3em;
      color: #FC8213;
      width: 70px;
      height: 70px;
      background: #fff;
      text-align: center;
      border-radius: 49px;
      -webkit-border-radius: 49px;
      -moz-border-radius: 49px;
      -o-border-radius: 49px;
      line-height: 1.7em;
    }

    .market-update-right i.fa.fa-bar-chart {
      font-size: 3em;
      color: #337AB7;
      width: 70px;
      height: 70px;
      background: #fff;
      text-align: center;
      border-radius: 49px;
      -webkit-border-radius: 49px;
      -moz-border-radius: 49px;
      -o-border-radius: 49px;
      line-height: 1.7em;
    }

    .market-update-left {
      padding: 0px;
    }
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
  <div class="market-updates">
  
    <div class="col-md-6 market-update-gd">
      <div class="market-update-block clr-block-2">
        <div class="col-md-8 market-update-left">
          <h3>${packagecount } </h3>
          <h4>Total Package Available</h4>

        </div>
        <div class="col-md-4 market-update-right">
          <i class="fa fa-globe"></i>
        </div>
        <div class="clearfix"> </div>
      </div>
    </div>
    <div class="col-md-6 market-update-gd">
      <div class="market-update-block clr-block-3">
        <div class="col-md-8 market-update-left">
          <h3>${bookingcount }</h3>
          <h4>Your Total Booking</h4>

        </div>
        <div class="col-md-4 market-update-right">
          <i class="fa fa-bar-chart"> </i>
        </div>
        <div class="clearfix"> </div>
      </div>
    </div>

  </div>
  <br><br>
</body>
<!--
  developed By : sumit kumar
  facebook : fb.com/sumit.luv
  youtube : youtube.com/lazycoders
  -->

</html>
    