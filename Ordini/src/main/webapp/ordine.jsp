<%
	String user = (String) session.getAttribute("username");
	if(user != null) {
%>

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
	<h3>Ordine effettuato</h3>
</div>
	<p><%= session.getAttribute("idOrdine") %></p>
	<% session.removeAttribute("carrello"); %>
	<p>Clicca <a href="acquisti.jsp">QUI</a>per continuare a fare altri acquisti!</p>
</div>
<footer><%@include file="footer.html" %></footer>
</body>
</html>
<%
	}
	else {
		response.sendRedirect("accessonegato.jsp");
	}
%>