<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<jsp:include page="nav.jsp" />
<div class="container">
<div class="page-header">
	<h3>Non puoi accedere a questa pagina</h3>
</div>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3><%= exception.getClass().getSimpleName() %></h3>
	</div>
	<div class="panel-body">
		<p><%= exception.getMessage() %></p>
		<p><% exception.printStackTrace(new PrintWriter(out)); %></p>
		
		<p>Torna alla pagina precedente</p>
		<input type="button" onclick="window.history.back()" class="btn btn-default" value="Indietro">	
	</div>
</div>
</div>
<footer><%@include file="footer.html" %></footer>
</body>
</html>