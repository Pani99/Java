<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Error 404</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h3>Impossibile caricare la risorsa richiesta</h3>
</div>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Pagina non trovata</h3>
	</div>
	<div class="panel-body">
		<p>Per segnalare il problema</p>
		<p><a href="mailto:admin@site.com">admin@site.com</a></p>
		<p>Oppure torna alla pagina precedente</p>
		<input type="button" onclick="window.history.back()" class="btn btn-default" value="Indietro">	
	</div>
</div>
</div>
<footer><%@include file="../footer.html" %></footer>
</body>
</html>