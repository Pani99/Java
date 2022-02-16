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
<title>Accesso utente</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h3>Inserire i dati per l'autenticazione</h3>
</div>
<form action="/<%=application.getServletContextName()%>/login" method="post" class="form-horizontal">

<!-- USERNAME -->
<div class="form-group">
	<label class="col-md-1 control-label">Username</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="username" placeholder="Inserisci il tuo Username.." class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoUsername"></div>
</div>

<!-- PASSWORD -->
<div class="form-group">
	<label class="col-md-1 control-label">Password</label>
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			 <span class="input-group-addon">
				<i class="glyphicon glyphicon-lock"></i>
			</span>
			<input type="password" name="password" placeholder="Inserisci la tua password.." class="form-control">
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoPassword"></div>
</div>

<div class="row">
	<div class="col-md-4 col-md-offset-1">
		<button type="submit" class="btn btn-warning">
			Entra&nbsp;<span class="glyphicon glyphicon-login"></span>		
		</button>
	</div>
</div>
</form>
</div>
<footer><%@include file="footer.html" %></footer>
</body>
</html>