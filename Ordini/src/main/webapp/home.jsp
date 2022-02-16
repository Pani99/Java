<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<form action="/<%=application.getServletContextName()%>/login" method="post" class="form-horizontal">
<div class="well" id="titolino">
<h3 style="color: white;">Negozio On-line</h3>
<p style="color: white;">
	<a class="btn btn-primary btn-lg" href="registra.jsp">
	Registrati &raquo;
	</a>
</p>

</div>
<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="img/iphone.png" alt="iPhone 11">
    </div>

    <div class="item">
      <img src="img/airpods.png" alt="Apple Airpods">
    </div>

    <div class="item">
      <img src="img/s20.png" alt="Samsung Galaxy s20">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Precedente</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Successivo</span>
  </a>
  
  </div>
</div>
</form>
<footer><%@include file="footer.html" %></footer>
</body>
</html>